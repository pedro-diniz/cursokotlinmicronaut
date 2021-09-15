package br.com.zup.atividade515

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class TicketRequest(
    @field:NotBlank @field:Size(max = 60) val titulo: String,
    @field:NotBlank @field:Size(max = 4000) val descricao: String
) {

    fun paraTicket() : Ticket {
        return Ticket(
            titulo,
            descricao
        )
    }

}