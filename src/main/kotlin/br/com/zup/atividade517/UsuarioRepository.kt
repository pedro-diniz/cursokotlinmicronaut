package br.com.zup.atividade517

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByUsername(username : String) : Usuario?

}