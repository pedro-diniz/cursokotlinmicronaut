package br.com.zup.atividade521

import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import java.time.LocalDateTime
import javax.validation.Valid

@Validated @Controller("/transacoes")
class TransacaoController(val transacaoRepository: TransacaoRepository) {

    @Post
    fun cadastra(@Valid transacao: Transacao) {
        transacaoRepository.save(transacao)
    }

    @Get
    fun lista() : HttpResponse<Any> {

        val transacoes = transacaoRepository.findByCriadaEmAfter(
            LocalDateTime.now().minusMonths(1),
            Pageable.from(0, 10, Sort.of(Sort.Order.desc("criadaEm")))
        )
        return HttpResponse.ok(transacoes)

    }

}