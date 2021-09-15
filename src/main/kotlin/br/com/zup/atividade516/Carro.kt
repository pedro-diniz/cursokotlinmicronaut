package br.com.zup.atividade516

import javax.persistence.*

@Entity
class Carro(
    @field:Column(nullable = false, unique = true) val placa: String,
    @field:Column(length = 60, nullable = false) val modelo: String
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null

    override fun toString(): String {
        return "Carro(placa='$placa', modelo='$modelo')"
    }
}