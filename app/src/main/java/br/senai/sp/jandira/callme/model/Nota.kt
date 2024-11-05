package br.senai.sp.jandira.callme.model

data class NotasResponse(
    val dados: List<Postagem>,
    val quantidade: Int,
    val status_code: Int
)

data class Postagem(
    val id: Int,
    val conteudo: String,
    val data_postagem: String,
    val deletada: Int,
    val usuario: Usuario,
    val respostas: List<Resposta>
)

data class Usuario(
    val id: Int,
    val foto: String,
    val tipo_usuario: Int
)

data class Resposta(
    val id: Int,
    val conteudo: String,
    val id_usuario: Int
)