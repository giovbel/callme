package br.senai.sp.jandira.callme.service

import br.senai.sp.jandira.callme.model.Cliente
import br.senai.sp.jandira.callme.model.ClienteResponse
import br.senai.sp.jandira.callme.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ClienteService {


    @GET("/v1/callme/cliente")
    fun getAllClientes(): Call<Result>

//    @GET("cliente/{id}")
//    fun getClienteById( @Path("id") id: Int): Call<Cliente>
//

    @Headers("Content-Type: application/json")
    @POST("/v1/callme/login")
    fun loginUsuario(@Body loginCliente: Cliente): Call<LoginResponse>


    @Headers("Content-Type: application/json")
    @POST("/v1/callme/cliente")
    fun cadastrarCliente(@Body cliente: Cliente): Call<ClienteResponse>

}