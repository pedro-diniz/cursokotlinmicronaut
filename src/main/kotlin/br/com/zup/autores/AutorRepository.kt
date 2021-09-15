package br.com.zup.autores

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {

    fun findByNomeAndEmail(nome: String, email: String) : Optional<Autor>

    @Query("SELECT a FROM Autor a WHERE a.email = :email")
    fun buscaPorEmail(email: String) : Optional<Autor>

    @Query(nativeQuery = true, value = "SELECT * FROM autor WHERE autor.nome = :nome")
    fun buscaPorNome(nome: String) : Optional<Autor>

}