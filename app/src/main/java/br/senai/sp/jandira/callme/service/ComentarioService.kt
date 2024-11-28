package br.senai.sp.jandira.callme.service

import br.senai.sp.jandira.callme.model.Comentario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ComentarioService {

    @GET("comentarios")
    fun getAllComentarios(): Call<List<Comentario>>

    @POST("comentarios")
    fun addComentario(@Body comentario: Comentario): Call<Comentario>

}