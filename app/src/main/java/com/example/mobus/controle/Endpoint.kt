package com.example.mobus.controle

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint
{
    //Locais
    @GET("/Places")
    fun getPlaces() : Call<List<Places>>


    //Autorização
    @GET("/Auth")
    fun getAuth() : Call<List<Auth>>
}

