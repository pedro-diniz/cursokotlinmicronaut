package br.com.zup.atividade521

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime

// não colocar data class em DTO de saída :)
//class TransacaoResponse(transacao: Transacao) {
//    val descricao = transacao.descricao
//    val valor = transacao.valor
//    @field:JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") val criadaEm : LocalDateTime = transacao.criadaEm
//}

// fazendo assim, só trago do banco os dados necessários, ao invés de trazer a Transacao completa e depois podá-la
@Introspected
data class TransacaoResponse(
    val descricao: String,
    val valor: BigDecimal,
    @field:JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") val criadaEm : LocalDateTime
)