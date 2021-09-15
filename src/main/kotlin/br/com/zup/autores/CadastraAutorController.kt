package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated // garantir que todos os métodos deste Controller irão rodar a validação
@Controller("/autores") // junção do @RestController e @RequestMapping("/autores")
class CadastraAutorController(val autorRepository: AutorRepository, val enderecoClient: EnderecoClient) {

    @Post // igual ao PostMapping
    // @Valid igual ao Spring
    fun cadastra(@Valid request: NovoAutorRequest) : HttpResponse<Any> { // @Body implícito, funciona igual ao @RequestBody do Spring
        println("Request => ${request}")

        // fazer uma requisição para um serviço externo
        val enderecoResponse: HttpResponse<EnderecoResponse> = enderecoClient.consulta(request.cep)

        // request => domínio
        if (enderecoResponse.body.isEmpty) {
            return HttpResponse.badRequest()
        }
        val autor = request.paraAutor(enderecoResponse.body.get())

        autorRepository.save(autor)

        println("Autor => ${autor.nome}")

        val uri = UriBuilder.of("/autores/{id}")
            .expand(mutableMapOf(Pair("id", autor.id)))

        return HttpResponse.created(uri)

    }

}