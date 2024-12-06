package br.senai.sp.jandira.callme.service

import br.senai.sp.jandira.callme.model.Cliente
import br.senai.sp.jandira.callme.model.ClienteResponse
import br.senai.sp.jandira.callme.model.ResultAvatares
import br.senai.sp.jandira.callme.model.diariolista
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ClienteService {

    @GET("/cliente")
    fun getAllClientes(): Call<List<ClienteResponse>>

    @GET("cliente/{id}")
    fun getClienteById(@Path("id") id: Int): Call<ClienteResponse>

    @Headers("Content-Type: application/json")
    @POST("login")
    fun loginUsuario(@Body loginCliente: Cliente): Call<ClienteResponse>

    @Headers("Content-Type: application/json")
    @POST("cliente")
    fun cadastrarCliente(@Body cliente: Cliente): Call<ClienteResponse>

    @GET("avatares")
    fun getAvatares(): Call<ResultAvatares>

}


