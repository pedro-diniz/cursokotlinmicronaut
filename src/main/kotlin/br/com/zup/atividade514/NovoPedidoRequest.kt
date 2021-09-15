package br.com.zup.atividade514

import java.math.BigDecimal
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class NovoPedidoRequest(
    @field:NotNull @field:Valid val cliente: Cliente,
    @field:NotEmpty @field:Valid val itens: List<ItemDePedido>
    ) {

    fun paraPedido() : Pedido {
        return Pedido(
            cliente,
            getTotalPrecos(),
            itens
        )

    }

    fun getTotalPrecos() : BigDecimal {
        val listaPrecos : MutableList<BigDecimal> = mutableListOf()
        for (itemPedido in itens) {
            listaPrecos.add(itemPedido.preco)
        }
        val totalPrecos = listaPrecos.reduce { acc, preco ->
            acc + preco
        }
        return totalPrecos
    }
}