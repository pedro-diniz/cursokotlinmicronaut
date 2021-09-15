package br.com.zup.atividade521

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Transacao(
    val descricao: String,
    val valor: BigDecimal,
    val clienteId: Long,
    @Enumerated(EnumType.STRING)
    val status: StatusDaTransacao) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val criadaEm: LocalDateTime = LocalDateTime.now()

    // varios outros atributos

}
