package com.example.mobus.model



import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import rx.Observable


public interface Endpoint
{
    @GET("/Bus/RetrieveGPS?id=1")
    fun getBusByLine(): Call<BusDTO>


    @GET("/Bus/RetrieveAllGPS")
    fun getAllBus(): Call <List<BusDTO>>
}
