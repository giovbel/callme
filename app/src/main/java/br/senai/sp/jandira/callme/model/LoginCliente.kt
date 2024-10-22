package br.senai.sp.jandira.callme.model

data class LoginCliente(
    val login: String,
    val senha: String,
)

data class LoginResponse(
    val code: Int,
    val id: Int,
    val status_code: Int
)
