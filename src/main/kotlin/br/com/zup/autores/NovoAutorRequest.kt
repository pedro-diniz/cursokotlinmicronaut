package br.com.zup.autores

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected // no momento de compilação, o Micronaut declara isso como um introspecction bean.
    // Basicamente, é necessário para que o Micronaut acesse os atributos e métodos da classe.
data class NovoAutorRequest( // data class para acesso aos métodos toString, equals, hashCode e copy
    // val para evitar injeções de dados e isolar nossa entidade
    @field:NotBlank val nome: String,
    @field:NotBlank @field:Email val email: String,
    @field:NotBlank @field:Size(max = 400) val descricao: String,
    @field:NotBlank val cep: String,
    @field:NotBlank val numero: String) {

    fun paraAutor(enderecoResponse: EnderecoResponse): Autor {
        val endereco = Endereco(enderecoResponse, numero)
        return Autor(nome, email, descricao, endereco)
    }

}