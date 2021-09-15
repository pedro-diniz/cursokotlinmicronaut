package br.com.zup.atividade522

class NotaFiscalResponse(notaFiscal: NotaFiscal) {
    val numero = notaFiscal.numero
    val serie = notaFiscal.serie
    val data = notaFiscal.data
    val itens = notaFiscal.itens.map { itemDeNota -> ItemDeNotaResponse(itemDeNota) }
}