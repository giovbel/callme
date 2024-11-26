package br.senai.sp.jandira.callme.service

import android.telecom.Call
import br.senai.sp.jandira.callme.model.Comentario
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

interface ComentariosService {

    @GET("comentarios")
    fun getAllComentarios(): Call<List<Comentario>>

    @POST("comentarios")
    fun addComentario(@Body comentario: ComentariosService): Call<Comentario>
}
