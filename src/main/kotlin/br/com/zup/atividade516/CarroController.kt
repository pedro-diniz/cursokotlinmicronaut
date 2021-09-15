package br.com.zup.atividade516

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated @Controller("/carros")
class CarroController(val carroRepository: CarroRepository) {

    @Post
    fun cadastra(@Valid request: CarroRequest) : HttpResponse<Any> {

        val possivelCarro = carroRepository.findByPlaca(request.placa)
        if (possivelCarro != null) {
            return HttpResponse.badRequest("Carro já cadastrado")
        }

        val carro = request.paraCarro()
        println(carro)
        carroRepository.save(carro)

        return HttpResponse.created(carro)

    }

}