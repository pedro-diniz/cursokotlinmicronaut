package br.com.zup.atividade514

import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ItemDePedido (
    @field:NotBlank val codigo: String,
    @field:NotNull val preco: BigDecimal,
    @field:NotNull @field:Positive val quantidade: Int
        )