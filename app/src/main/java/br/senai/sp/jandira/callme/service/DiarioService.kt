package br.senai.sp.jandira.callme.service

import br.senai.sp.jandira.callme.model.Diario
import br.senai.sp.jandira.callme.model.diarioResponse
import br.senai.sp.jandira.callme.model.diariolista
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface DiarioService {
    @Headers("Content-Type: application/json")
    @POST("diario")
    fun addDiario(@Body diario: Diario): Call<diarioResponse>

    @GET("diarios/usuario/{id}")
    fun getDiario(@Path("id") id: Int): Call<diariolista>
}

