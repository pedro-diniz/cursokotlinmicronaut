package br.com.zup.atividade517

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller
class ExibirPerfilDoUsuarioController(val repository: UsuarioRepository) {

    @Get("/api/users/{username}/profile")
    fun exibir(@PathVariable username: String): HttpResponse<Any> {

        val usuario = repository.findByUsername(username)
        if (usuario == null) {
            return HttpResponse.notFound()
        }

        return HttpResponse.ok(usuario.paraDetalhes())
    }

}
