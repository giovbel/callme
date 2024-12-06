package br.senai.sp.jandira.callme.model

data class diarioResponse(
val dados: Cliente?=null,
val status: Boolean,
val status_code: Int = 0,
val message: String,
    val id_criado: Int = 0
)


