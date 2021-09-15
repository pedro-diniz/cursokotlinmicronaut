package br.com.zup.atividade522

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Controller("/notasFiscais") @Validated
class NotaFiscalController(val notaFiscalRepository: NotaFiscalRepository) {

    @Post("/notas")
    fun cadastraNF(@Valid notaFiscal: NotaFiscal) {
        notaFiscalRepository.save(notaFiscal)
    }

    @Post("/itens/{idNotaFiscal}")
    fun cadastraitem(@Valid request: ItemDeNotaRequest, @PathVariable idNotaFiscal: Long) : HttpResponse<Any> {
        println(idNotaFiscal)
        val possivelNota = notaFiscalRepository.findById(idNotaFiscal)
        if (possivelNota.isPresent) {
            val nota = possivelNota.get()
            println(nota)
            val item = request.paraItemDeNota(nota)
            println(item)
            nota.adiciona(item)
            notaFiscalRepository.update(nota)

            return HttpResponse.ok()
        }
        return HttpResponse.notFound()
    }

    @Get("/{id}")
    @Transactional // faz o LAZY fetch funcionar.
        // Por padrão, o Spring abre e fecha uma transação por chamada do repository.
        // O Transactional aqui faz com que tudo seja feito em apenas uma transação
    fun buscaPorId(@PathVariable id: Long) : HttpResponse<Any> {
        val nota = notaFiscalRepository.findByIdWithItens(id)
//        val nota = notaFiscalRepository.buscaNotaFiscalEItens(id)

        if (nota.isPresent) {
            val saida = NotaFiscalResponse(nota.get())
            return HttpResponse.ok(saida)
        }
        return HttpResponse.notFound()
    }

}