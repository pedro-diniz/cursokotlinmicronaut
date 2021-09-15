package br.com.zup.atividade526

import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.*

@Introspected
data class ClienteRequest(
    @field:NotBlank @field:Size(max=120)
    val nome: String,
    @field:Email
    val email: String,
    @field:NotNull @field:Past @field:MaiorDeIdade val dataDeNascimento: LocalDate,
)
