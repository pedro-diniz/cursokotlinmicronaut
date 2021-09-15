package br.com.zup.atividade526

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated @Controller
class ClienteController {

    @Post("/ultimoExercicio/clientes")
    fun cadastra(@Valid clienteRequest: ClienteRequest) : HttpResponse<Any> {
        return HttpResponse.ok(clienteRequest)
    }

}