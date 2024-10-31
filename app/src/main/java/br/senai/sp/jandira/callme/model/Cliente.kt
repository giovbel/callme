package br.senai.sp.jandira.callme.model

data class Cliente(
    val nome: String = "",
    val login: String = "",
    val senha: String = "",
    val cpf: String = "",
    val nascimento: String = "",
    val idAvatar: Int=1
)

