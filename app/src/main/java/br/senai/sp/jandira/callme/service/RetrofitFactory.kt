package br.senai.sp.jandira.callme.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    private const val BASE_URL = "http://10.0.2.2:3000/v1/callme/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getClienteService(): ClienteService {
        return retrofit.create(ClienteService::class.java)
    }

    fun getNotasService(): NotaService {
        return retrofit.create(NotaService::class.java)
    }

    fun getComentarioService(): ComentarioService {
        return retrofit.create(ComentarioService::class.java)
    }
}
