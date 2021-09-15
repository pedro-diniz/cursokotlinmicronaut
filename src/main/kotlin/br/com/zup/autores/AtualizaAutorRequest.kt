package br.com.zup.autores

import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class AtualizaAutorRequest(
    val nome: String?,
    @field:Email val email: String?,
    @field:Size(max = 400) val descricao: String?
)