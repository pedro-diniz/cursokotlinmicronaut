package br.com.zup.autores

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity // toda classe @Entity é @Introspected por padrão
class Autor(
    var nome: String,
    var email: String,
    var descricao: String,
    var endereco: Endereco) {

        // o ID fica dentro do corpo pq não faz parte do construtor. É var pra que a JPA altere o ID iniciado com nulo
        @Id @GeneratedValue
        var id: Long? = null

        val criadoEm: LocalDateTime = LocalDateTime.now()

        fun atualiza(request: AtualizaAutorRequest) : PossivelAtualizacao {
//        fun atualiza(request: AtualizaAutorRequest) : Map<String, Any> {
            var atualizou = false
            if (request.nome != null && request.nome.trim() != "") {
                nome = request.nome
                atualizou = true
            }
            if (request.email != null && request.email.trim() != "") {
                email = request.email
                atualizou = true
            }
            if (request.descricao != null && request.descricao.trim() != "") {
                descricao = request.descricao
                atualizou = true
            }

            return PossivelAtualizacao(atualizou, this)
//            return mapOf(
//                Pair("atualizou", atualizou),
//                Pair("autorAtualizado", this)
//            )
        }

    }