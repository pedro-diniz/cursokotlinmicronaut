package br.com.zup.atividade523

import jakarta.inject.Inject
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
class ArtigoService(@Inject val repository: ArtigoRepository) {

    @Transactional
    fun comenta(id: Long, comentario: Comentario) {

        val possivelArtigo = repository.findById(id)
        if (possivelArtigo.isEmpty) {
            println("caí aqui")
            throw ArtigoNaoEncontradoException("Artigo não encontrado")
        }
        val artigo = possivelArtigo.get()

        artigo.comenta(comentario)

        // atualiza entidade no banco
//        repository.update(artigo)
    }
}
