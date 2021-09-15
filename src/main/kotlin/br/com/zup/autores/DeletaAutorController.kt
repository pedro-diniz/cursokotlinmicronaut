package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable

@Controller("/autores/{id}")
class DeletaAutorController(val autorRepository: AutorRepository) {

    @Delete
    fun deleta(@PathVariable id: Long) : HttpResponse<Any> {

        val possivelAutor = autorRepository.findById(id)
        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound()
        }

        val autor = possivelAutor.get()
        autorRepository.delete(autor) // deleta por objeto da entidade
//        autorRepository.deleteById(id) // deleta pelo id

        return HttpResponse.ok()

    }

}