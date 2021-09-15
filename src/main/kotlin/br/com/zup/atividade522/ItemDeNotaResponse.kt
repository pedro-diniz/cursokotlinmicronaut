package br.com.zup.atividade522

import io.micronaut.core.annotation.Introspected

@Introspected
class ItemDeNotaResponse(itemDeNota: ItemDeNota) {
    val valor = itemDeNota.valor
    val quantidade = itemDeNota.quantidade
}