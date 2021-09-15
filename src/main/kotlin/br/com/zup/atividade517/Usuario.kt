package br.com.zup.atividade517

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Usuario(
    @Id
    @GeneratedValue
    val id: Long,
    val username: String,
    val nome: String,
    val email: String,
    val senha: String,
    val fotoUrl: String,
    val endereco: String,
    val telefone: String,
    val token: String,
    val registradoEm: LocalDateTime,
    val criadoEm: LocalDateTime,
    val atualizadoEm: LocalDateTime,
) {

    fun paraDetalhes() : UsuarioResponse{
        return UsuarioResponse(fotoUrl, username, nome, email, registradoEm)
    }

}