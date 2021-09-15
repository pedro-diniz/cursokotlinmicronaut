package br.com.zup.atividade514

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated @Controller("/pedidos")
class PedidoController {

    @Post
    fun pedir(@Valid request: NovoPedidoRequest) {

        val pedido = request.paraPedido()
        println(pedido)

    }

}