package com.example.mobus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobus.api.Endpoint
import com.example.mobus.util.NetworkUtils
import com.google.gson.JsonObject
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getTodos(){
        val retrofitClient = NetworkUtils.getRetrofitInstance("https://jsonplaceholder.typicode.com")
        val endpoint = retrofitClient.create(Endpoint::class.java)

        val enqueue = endpoint.getTodos().enqueue(object : Callback<JsonObject> {

        })
    }
}