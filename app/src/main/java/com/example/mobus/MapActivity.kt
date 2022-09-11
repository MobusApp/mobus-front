package com.example.mobus

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobus.controle.*
import com.example.mobus.model.BusDTO
import com.google.android.gms.maps.SupportMapFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapActivity() {
    private val path: String = "http://26.26.59.28:8081"

    private fun loadApi(): Endpoint {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance(path)

        return retrofitClient.create(Endpoint::class.java)
    }

    /**
     * sem essa classe o map já aparece,
     * mas com ela podemos fazer manipuções e deixar métodos
     * assíncronos
     */
    public fun loadMap(comp: AppCompatActivity) {
        //intanciando utilitarios do mapa
        val mapsUtils: MapsUtils = MapsUtils()

        val places = loadApi().getAllPlaces()

        //Transformando o map em um fragmento
        val mapFragment = SupportMapFragment.newInstance()
        comp.supportFragmentManager
            .beginTransaction()
            .add(R.id.map_fragment, mapFragment)
            .commit()


        //Pesquisa e roda todos os itens da API
        places.enqueue(object : Callback<List<BusDTO>> {
            override fun onFailure(call: Call<List<BusDTO>>, t: Throwable) {
                Toast.makeText(comp.baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<BusDTO>>, response: Response<List<BusDTO>>) {
                val res = response.body()

                res?.forEach{ busDTO ->
                    mapFragment.getMapAsync { googleMap ->
                        mapsUtils.addMarkers(googleMap,
                            busDTO?.busLine.toString(),
                            busDTO?.macAddress.toString(),
                            busDTO?.latitude.toString(),
                            busDTO?.longitude.toString()
                        )
                        //Quando o mapa carregar completamente
                        mapsUtils.zoomProximity(googleMap)
                    }
                }
            }
        })
    }
}
