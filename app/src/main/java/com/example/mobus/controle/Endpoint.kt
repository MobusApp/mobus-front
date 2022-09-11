package com.example.mobus.controle


import com.example.mobus.model.BusDTO
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint
{

    //
    @GET("/Bus/RetrieveGPS?id=")
    fun getPlaces(): Call <BusDTO>

    @GET("/Bus/RetrieveAllGPS")
    fun getAllPlaces(): Call <List<BusDTO>>
}
