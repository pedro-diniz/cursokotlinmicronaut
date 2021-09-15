package br.com.zup.atividade522

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface NotaFiscalRepository : JpaRepository<NotaFiscal, Long> {

    // outros métodos implementados pelo time

    @Query(nativeQuery = true, value =
    "select * from nota_fiscal join item_de_nota on nota_fiscal.id " +
            "= item_de_nota.nota_fiscal_id where nota_fiscal.id = :id")
    fun buscaNotaFiscalEItens(id: Long) : Optional<NotaFiscal>

    @Query("select n from NotaFiscal n where n.id = :id")
    fun findByIdWithItens(id: Long): Optional<NotaFiscal>

}