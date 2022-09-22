package com.example.mobus.util

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobus.model.BusDTO
import com.example.mobus.model.Endpoint
import com.example.mobus.network.NetworkUtils
import com.google.android.gms.maps.GoogleMap
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class ApiUtils()
{

    companion object
    {
        private val BASE_URL: String = "http://192.168.0.112:8081"

        public fun loadApi(): Endpoint
        {
            val retrofitClient = NetworkUtils
                .getRetrofitInstance(BASE_URL)

            return retrofitClient.create(Endpoint::class.java)
        }

        public fun getAllBus(comp: AppCompatActivity, googleMap: GoogleMap)
        {
            val api = loadApi().getAllBus()
            val mapsUtils: MapsUtils = MapsUtils()


            api.enqueue(object : Callback<List<BusDTO>>
            {
                override fun onFailure(call: Call<List<BusDTO>>, t: Throwable)
                {
                    Toast.makeText(comp.baseContext, t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<List<BusDTO>>, response: Response<List<BusDTO>>)
                {
                    var res = response.body()

                    res?.forEach { busDTO ->
                        mapsUtils.addMarkers(googleMap,
                            busDTO?.busLine.toString(),
                            busDTO?.macAddress.toString(),
                            busDTO?.latitude.toString(),
                            busDTO?.longitude.toString()
                        )
                    }
                }
            })
        }


        public fun getBusByLine(comp: AppCompatActivity, googleMap: GoogleMap)
        {
            val api = loadApi().getBusByLine()
            val mapsUtils: MapsUtils = MapsUtils()

            api.enqueue(object : Callback<BusDTO>
            {
                override fun onFailure(call: Call<BusDTO>, t: Throwable)
                {
                    Toast.makeText(comp.baseContext, t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<BusDTO>, response: Response<BusDTO>)
                {
                    var res = response.body()

                    mapsUtils.addMarkers(googleMap,
                        res?.busLine.toString(),
                        res?.macAddress.toString(),
                        res?.latitude.toString(),
                        res?.longitude.toString()
                    )
                }
            })
        }
    }
}

