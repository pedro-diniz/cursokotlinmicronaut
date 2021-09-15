package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated @Controller("/autores")
class AtualizaAutorController(val autorRepository: AutorRepository) {

    @Put("/{id}") @Transactional
    fun atualizar(@PathVariable id: Long, @Valid request: AtualizaAutorRequest) : HttpResponse<Any> {
        val possivelAutor = autorRepository.findById(id)

        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound()
        }

        val autor = possivelAutor.get()

        val possivelAtualizacao = autor.atualiza(request)

        if (possivelAtualizacao.atualizou) {
            val autorAtualizado = possivelAtualizacao.autorAtualizado
//        if (possivelAtualizacao["atualizou"] == true) {
//            val autorAtualizado = possivelAtualizacao["autorAtualizado"] as Autor

//            autorRepository.update(autorAtualizado)
            // Posso omitir o .update() aqui. Por que?
                // Dentro de uma transação, o objeto que representa a entidade fica no estado managed.
                // Toda e qualquer alteração nele durante esse estado será posteriormente commitada ao banco.
                // Isso ocorre ao fim do método, quando o @Transactional fecha a transação.

//            return HttpResponse.ok(DetalhesDoAutorResponse(autorAtualizado))
            return HttpResponse.ok(autorAtualizado.paraResponse())
        }
        return HttpResponse.badRequest("Nenhum dado válido foi inserido para atualizar o autor.")

    }

}