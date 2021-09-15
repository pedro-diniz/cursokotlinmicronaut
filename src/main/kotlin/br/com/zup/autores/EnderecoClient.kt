package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("/http://localhost:8081/cep")
interface EnderecoClient {

    @Get("/{cep}")
    @Consumes(MediaType.APPLICATION_XML)
    // consumes é o resultado do consumo da API
    // produces é o formato que a API precisa pra produzir a resposta
    fun consulta(cep: String) : HttpResponse<EnderecoResponse>

}