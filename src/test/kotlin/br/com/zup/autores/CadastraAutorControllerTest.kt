package br.com.zup.autores

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito

@MicronautTest
internal class CadastraAutorControllerTest {

    @field:Inject
    lateinit var enderecoClient: EnderecoClient

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    internal fun deveCadastrarUmNovoAutor() {

        val novoAutorRequest = NovoAutorRequest(
            "Rafael Ponte",
            "rafael.ponte@zup.com.br",
            "O principe dos oceanos",
            "11222-333",
            "37")

        // cenário
        val request = HttpRequest.POST("/autores", novoAutorRequest)

        val enderecoResponse = EnderecoResponse(
            "Rua das Laranjeiras",
            "Rio de Janeiro",
            "RJ"
        )

        Mockito.`when`(enderecoClient.consulta(novoAutorRequest.cep)).thenReturn(HttpResponse.ok(enderecoResponse))

        // ação
        val response = client.toBlocking().exchange(request, Any::class.java)

        // corretude
        assertEquals(HttpStatus.CREATED, response.status)
        assertTrue(response.headers.contains("Location"))
        assertTrue(response.header("Location")!!.matches("/autores/\\d".toRegex()))

    }

    @MockBean(EnderecoClient::class) // bean a ser mockado
    fun enderecoMock() : EnderecoClient {
        return Mockito.mock(EnderecoClient::class.java)
    }
}