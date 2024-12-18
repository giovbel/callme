package br.senai.sp.jandira.callme.model


data class Comentario(
    val id: Int? = null,              // ID do comentário (opcional para novos comentários)
    val conteudo: String?="",            // Texto do comentário (obrigatório)
    val idNota: Int?=0,                 // ID da nota associada (obrigatório)
    val idUsuario: Int?=0,              // ID do usuário que criou o comentário (obrigatório)
    val dataCriacao: String? = null  // Data de criação do comentário (gerado pelo backend)
) {

}

