package br.com.zup.atividade523

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ArtigoRepository : JpaRepository<Artigo, Long> {

}
