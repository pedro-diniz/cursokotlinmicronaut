package br.com.zup.atividade523

class ComentarioRequest(
    val texto: String
) {

    fun toModel(artigo: Artigo) : Comentario {
        return Comentario(texto, artigo)
    }

}