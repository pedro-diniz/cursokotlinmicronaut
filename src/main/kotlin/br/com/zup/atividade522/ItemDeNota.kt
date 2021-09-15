package br.com.zup.atividade522

import java.math.BigDecimal
import javax.persistence.*

@Entity
class ItemDeNota(
    val valor: BigDecimal,
    val quantidade: Int,

    @ManyToOne
    val notaFiscal: NotaFiscal
    // outro atributos
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun paraResponse() : ItemDeNotaResponse {
        return ItemDeNotaResponse(this)
    }

}