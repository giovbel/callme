package br.senai.sp.jandira.callme.service

import br.senai.sp.jandira.callme.model.Cliente
import br.senai.sp.jandira.callme.model.ClienteResponse
import br.senai.sp.jandira.callme.model.NotaResponse
import br.senai.sp.jandira.callme.model.NotasResponse
import br.senai.sp.jandira.callme.model.Postagem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NotaService {
    @GET("notas?excluidas=false")
    fun getNotas(): Call<NotasResponse>


    @Headers("Content-Type: application/json")
    @POST("nota")
    fun adicionarNota(@Body nota: Postagem): Call<NotaResponse>
}
