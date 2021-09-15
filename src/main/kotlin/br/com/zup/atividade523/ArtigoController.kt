package br.com.zup.atividade523

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import jakarta.inject.Inject
import java.util.*
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller
class ArtigoController(@Inject val service: ArtigoService,
                       val artigoRepository: ArtigoRepository,
                       val comentarioRepository: ComentarioRepository) {

//    @Transactional
    @Post("/api/artigos/{id}/comentarios")
    fun novoComentario(@PathVariable id: Long, @Body @Valid request: ComentarioRequest): HttpResponse<Any> {

        val possivelArtigo = artigoRepository.findById(id)
        if (possivelArtigo.isEmpty) {
//            service.comenta(id = id, comentario = Comentario("deu ruim, rapaz", Artigo("fa", mutableListOf())))
            return HttpResponse.notFound()
        }
        val artigo = possivelArtigo.get()

        val comentario = request.toModel(artigo)
        if (isDuplicado(request, id)) {
            return HttpResponse.unprocessableEntity() // status 422
        }

        service.comenta(id = id, comentario = comentario)
        return HttpResponse.ok()
    }

    private fun isDuplicado(request: ComentarioRequest, artigoId: Long): Boolean {
        val possivelComentario = comentarioRepository.findByTextoAndArtigoId(request.texto, artigoId)
        if (possivelComentario.isEmpty()) {
            return false
        }
        return true
        // implementação não importante
    }
}
