package br.com.zup.atividade515

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated @Controller("/tickets")
class TicketController(val ticketRepository: TicketRepository) {

    @Post
    fun cadastra(@Valid request: TicketRequest) {

        val ticket = request.paraTicket()
        println(ticket)
        ticketRepository.save(ticket)

    }

}