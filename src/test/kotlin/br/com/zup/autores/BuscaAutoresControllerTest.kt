package br.com.zup.autores

import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@MicronautTest // para que o Micronaut possa gerenciar todos os beans no contexto do teste
internal class BuscaAutoresControllerTest {

    lateinit var autor: Autor

    @field:Inject
    lateinit var autorRepository: AutorRepository

    @field:Inject
    @field:Client(value="/")
    lateinit var client: HttpClient

    @BeforeEach
    internal fun setUp() {
        val endereco = Endereco(EnderecoResponse("Rua das Laranjeiras", "Rio de Janeiro", "RJ"), "28")
        autor = Autor("Rafael Ponte", "rafael.ponte@zup.com.br", "Marajá dos legados", endereco = endereco)

        autorRepository.save(autor)
    }

    @AfterEach
    internal fun tearDown() {
        autorRepository.deleteAll()
    }

    @Test
    internal fun deveRetornarOsDetalhesDeUmAutor() {

        val response = client.toBlocking().exchange("/autores?email=${autor.email}", DetalhesDoAutorResponse::class.java)
//        val response = HttpResponse.ok(autorRepository.buscaPorEmail(autor.email).get().paraResponse()) // mesma coisa

        assertEquals(HttpStatus.OK, response.status)
        assertNotNull(response.body())
        assertEquals(autor.nome, response.body()!!.nome)
        assertEquals(autor.email, response.body()!!.email)
        assertEquals(autor.descricao, response.body()!!.descricao)

    }

}