package br.senai.sp.jandira.callme.model

data class ClienteResponse(
    val id: Int,
    val message: String,
    val status_code: Boolean,
    val idCriadoUsuario: Int,
    val resultCliente: List<Cliente>
)