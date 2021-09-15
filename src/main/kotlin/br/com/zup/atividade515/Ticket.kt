package br.com.zup.atividade515

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Ticket(
    val titulo: String?,
    val descricao: String?,
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null

    @Enumerated(EnumType.STRING)
    var status : TicketStatus = TicketStatus.ABERTO
    val criadoEm : LocalDateTime = LocalDateTime.now()

    override fun toString(): String {
        return "Ticket(titulo=$titulo, descricao=$descricao, id=$id, status=$status, criadoEm=$criadoEm)"
    }

}