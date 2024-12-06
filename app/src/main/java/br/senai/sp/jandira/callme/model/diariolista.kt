package br.senai.sp.jandira.callme.model

data class diariolista(
    val dados: List<Diario>?=null,
    val quantidade: Int=0,
    val status_code: Int=0

)
