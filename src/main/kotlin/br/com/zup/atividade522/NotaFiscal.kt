package br.com.zup.atividade522

import java.time.LocalDate
import javax.persistence.*

@Entity
class NotaFiscal(
    val numero: String,
    val serie: String,
    val data: LocalDate,
// outros atributos
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.MERGE))
    @JoinColumn(name = "nota_fiscal_id")
    val itens: MutableList<ItemDeNota> = mutableListOf()

    fun adiciona(itemDeNota: ItemDeNota) {
        itens.add(itemDeNota)
        println(itens)
    }
}