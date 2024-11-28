package br.senai.sp.jandira.callme.service

import br.senai.sp.jandira.callme.model.Diario
import br.senai.sp.jandira.callme.model.diarioResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DiarioService {
    @POST("diario")
    fun addDiario(@Body diario: Diario): Call<diarioResponse>


}