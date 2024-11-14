package br.senai.sp.jandira.callme.model

data class NotasResponse(
    val dados: List<Postagem>,
    val quantidade: Int,
    val status_code: Int
)

data class Postagem(
    val id: Int=0,
    val conteudo: String="",
    val data_postagem: String="",
    val deletada: Int=0,
    val usuario: Usuario?=null,
    val respostas: List<Resposta>?=null,
    val idUsuario: Int=0

)
data class NotaResponse(
    val dados: Postagem,
    val quantidade: Int,
    val status_code: Int
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