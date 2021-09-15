package br.com.zup.atividade523

import javax.persistence.*

@Entity
class Comentario(
    val texto: String,
    @ManyToOne
    var artigo: Artigo,
    // outros atributos
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
