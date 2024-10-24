package br.senai.sp.jandira.callme.service


import br.senai.sp.jandira.callme.model.Cliente
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "http://192.168.56.1:3000"



    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getClienteService(): ClienteService {
        return retrofitFactory.create(ClienteService::class.java)
    }


}