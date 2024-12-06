package br.senai.sp.jandira.callme.model

data class ClienteResponse(
    val message: String = "",
    val status_code: Int = 0,
    val idCriadoUsuario: Int = 0,
    val id: Int = 0,
    val resultCliente: List<Cliente>?=null
)