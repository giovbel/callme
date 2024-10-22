package br.senai.sp.jandira.vivaris.service

import br.senai.sp.jandira.callme.model.Cliente
import br.senai.sp.jandira.callme.model.ClienteResponse
import br.senai.sp.jandira.callme.model.LoginCliente
import br.senai.sp.jandira.callme.model.LoginResponse
import br.senai.sp.jandira.callme.model.Result
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ClienteService {


    @GET("cliente")
    fun getAllClientes(): Call<Result>

//    @GET("cliente/{id}")
//    fun getClienteById( @Path("id") id: Int): Call<Cliente>
//

    @Headers("Content-Type: application/json")
    @POST("login")
    fun loginUsuario(@Body loginCliente: LoginCliente): Call<LoginResponse>


    @Headers("Content-Type: application/json")
    @POST("cliente")
    fun cadastrarCliente(@Body cliente: Cliente): Call<ClienteResponse>

}