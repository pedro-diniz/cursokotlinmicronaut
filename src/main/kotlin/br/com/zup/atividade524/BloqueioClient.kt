package br.com.zup.atividade524

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.micronaut.validation.Validated
import java.util.*
import javax.validation.Valid

@Validated @Client("https://api.de.terceiro.com")
interface BloqueioClient {

    @Post("/api/cartoes/{cartaoId}/bloquear")
    fun bloqueia(
        @PathVariable cartaoId: String,
        @Valid bloqueioRequest: BloqueioRequest,
        @Header(name = "X-Request-Id", value = "\${UUID.randomUUID()}") requestId : UUID
    ) : HttpResponse<Any>

}