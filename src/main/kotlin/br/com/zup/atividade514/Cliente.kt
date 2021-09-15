package br.com.zup.atividade514

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class Cliente (
    @field:NotBlank val nome: String,
    @field:NotBlank @field:Email val email: String
    )