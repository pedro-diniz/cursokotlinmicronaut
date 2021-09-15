package br.com.zup.atividade523

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface ComentarioRepository : JpaRepository<Comentario, Long> {

    fun findByTextoAndArtigoId(texto: String, artigo_id: Long) : Optional<Comentario>

}