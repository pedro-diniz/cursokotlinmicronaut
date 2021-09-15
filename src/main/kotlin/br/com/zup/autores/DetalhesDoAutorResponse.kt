package br.com.zup.autores

import io.micronaut.core.annotation.Introspected

// esse código aqui não funcionou com meu código de testes. Depois queria entender o porquê
//class DetalhesDoAutorResponse(autor: Autor) {
//
//    val nome = autor.nome
//    val email = autor.email
//    val descricao = autor.descricao
//
//}

@Introspected
data class DetalhesDoAutorResponse(
    val nome: String,
    val email: String,
    val descricao: String
)