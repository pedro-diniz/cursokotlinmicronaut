package br.com.zup.atividade523

import java.util.*
import javax.persistence.*

@Entity
class Artigo(
    val nome: String,
    @OneToMany(mappedBy = "artigo", cascade = arrayOf(CascadeType.ALL))
val comentarios: MutableList<Comentario>,
// outros atributos
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    /**
     * Adiciona novo comentário ao artigo
     */
    fun comenta(comentario: Comentario) {
        comentario.artigo = this
        this.comentarios.add(comentario)
    }

}
