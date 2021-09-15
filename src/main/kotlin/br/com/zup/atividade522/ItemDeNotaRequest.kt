package br.com.zup.atividade522

import java.math.BigDecimal

data class ItemDeNotaRequest (
    val valor: BigDecimal,
    val quantidade: Int,
    val notaFiscalId: Long
        ) {

    fun paraItemDeNota(notaFiscal: NotaFiscal) : ItemDeNota {

        return ItemDeNota(
            valor, quantidade, notaFiscal
        )

    }

}