package br.com.zup.atividade516

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class CarroRequest(
    @field:NotBlank @field:Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}") val placa: String,
    @field:NotBlank @field:Size(max = 60) val modelo: String
) {

    fun paraCarro() : Carro{
        return Carro(
            placa,
            modelo
        )
    }

}