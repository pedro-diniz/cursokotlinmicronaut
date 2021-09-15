package br.com.zup.atividade517

import java.time.LocalDateTime

data class UsuarioResponse(
    val fotoUrl: String,
    val username: String,
    val nome: String,
    val email: String,
    val registradoEm: LocalDateTime
)