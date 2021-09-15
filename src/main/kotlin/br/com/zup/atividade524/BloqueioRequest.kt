package br.com.zup.atividade524

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.validation.constraints.*

data class BloqueioRequest(
    @field:NotBlank val titular: String,
    @field:JsonFormat(pattern = "yyyy-MM") val expiraEm: LocalDate,
    @field:NotNull @field:Positive @field:Min(111) @field:Max(999) val cvv: Int
)