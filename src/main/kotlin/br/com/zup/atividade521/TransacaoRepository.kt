package br.com.zup.atividade521

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import java.time.LocalDateTime

@Repository
interface TransacaoRepository : JpaRepository<Transacao, Long> {

    fun findByCriadaEmAfter(data : LocalDateTime, pageable: Pageable) : Page<TransacaoResponse>

    // outros métodos implementados pelo time
}
