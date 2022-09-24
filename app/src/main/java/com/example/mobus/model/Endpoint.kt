package com.example.mobus.model



import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST


public interface Endpoint
{
    @GET("/Bus/RetrieveGPS?id=1")
    fun getBusByLine(): Call<BusDTO>

    @GET("/Bus/RetrieveAllGPS")
    fun getAllBus(): Call <List<BusDTO>>

    @GET("/User/Login?username=1&password=1")
    fun login(): Call<UserDTO>

    //create a endpoint for the user to register
    @POST("/User/Register?username=1&password=1")
    fun register(): Call<UserDTO>

    //create a endpoint for the user to update
    @POST("/User/Update?username=1&password=1")
    fun update(): Call<UserDTO>

    //create a endpoint for news
    @GET("/News")
    fun getNews(): Call<NewsDTO>

}
