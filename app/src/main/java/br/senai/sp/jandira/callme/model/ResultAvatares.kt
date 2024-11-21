package br.senai.sp.jandira.callme.model

data class ResultAvatares(
    val status_code: Int = 0,
    val quantidade: Int = 0,
    val dados: List<avatares>?=null
)
