package br.senai.sp.jandira.callme.model

data class Diario(
    val titulo: String = "",
    val conteudo: String = "",
    val dataPublicacao: String = "",
    val classificacao: Int=1,
    val idUsuario: Int=1
)


