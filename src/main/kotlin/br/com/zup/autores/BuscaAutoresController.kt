package br.com.zup.autores

import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import java.util.*

@Controller("/autores")
class BuscaAutoresController(val autorRepository: AutorRepository) {

    @Get
    fun lista(
        @QueryValue(defaultValue = "") email: String,
        @QueryValue(defaultValue = "") nome: String,
    ): HttpResponse<Any> {

        val possivelAutor: Optional<Autor>

        when {
            email.isBlank() && nome.isBlank() -> {
                val autores = autorRepository.findAll(
                    Pageable.from(0, 10, Sort.of(Sort.Order.asc("nome"))))
                val resposta = autores.map { autor -> DetalhesDoAutorResponse(autor) }
                return HttpResponse.ok(resposta)
            }
            nome.isBlank() -> possivelAutor = autorRepository.buscaPorEmail(email)

            email.isBlank() -> possivelAutor = autorRepository.buscaPorNome(nome)

            else -> possivelAutor = autorRepository.findByNomeAndEmail(nome, email)
        }

        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound()
        }

        val autor = possivelAutor.get()

        return HttpResponse.ok(DetalhesDoAutorResponse(autor))

    }

}