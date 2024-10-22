package br.senai.sp.jandira.callme.model

data class Cliente(
    val id: Int = 0,
    val nome: String,
    val data_nascimento: String,
    val foto: String,

)

data class ClienteResponse(
    val dados: Cliente,
    val status_code: Int,
    val message: String
)
