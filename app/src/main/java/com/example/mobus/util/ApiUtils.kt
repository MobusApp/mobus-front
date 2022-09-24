package com.example.mobus.util

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobus.model.BusDTO
import com.example.mobus.model.Endpoint
import com.example.mobus.network.NetworkUtils
import com.google.android.gms.maps.GoogleMap
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class ApiUtils()
{

    companion object
    {
        private val BACK_URL: String = "http://192.168.0.112:8081"
        private val MAPS_API_URL: String = "https://maps.googleapis.com/maps/api"


        public fun getBusByLine(comp: AppCompatActivity, googleMap: GoogleMap)
        {
            val api = NetworkUtils.getRetrofitInstance(BACK_URL).getBusByLine()

            api.enqueue(object : Callback<BusDTO>
            {
                override fun onFailure(call: Call<BusDTO>, t: Throwable)
                {
                    Toast.makeText(comp, "Error: " + t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<BusDTO>, response: Response<BusDTO>)
                {
                    if (response.isSuccessful)
                    {
                        val busDTO: BusDTO = response.body()!!

                        MapsUtils.addOneMarker(
                            googleMap,
                            busDTO.busLine.toString(),
                            busDTO.macAddress.toString(),
                            busDTO.latitude.toString(),
                            busDTO.longitude.toString()
                        )

                    }
                }
            })
        }
    }
}

