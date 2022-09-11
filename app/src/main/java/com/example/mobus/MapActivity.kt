package com.example.mobus

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobus.controle.Endpoint
import com.example.mobus.controle.MapsUtils
import com.example.mobus.controle.NetworkUtils
import com.example.mobus.controle.Places
import com.google.android.gms.maps.SupportMapFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapActivity()
{
    private val path : String = "http://192.168.0.112:5000"

    private fun loadApi(): Endpoint
    {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance(path)

        return retrofitClient.create(Endpoint::class.java)
    }

    /**
     * sem essa classe o map já aparece,
     * mas com ela podemos fazer manipuções e deixar métodos
     * assíncronos
     */
    public fun loadMap(comp : AppCompatActivity)
    {
        val places = loadApi().getPlaces()
        //intanciando utilitarios do mapa
        val mapsUtils: MapsUtils = MapsUtils()

        //Transformando o map em um fragmento
        val mapFragment = SupportMapFragment.newInstance()
            comp.supportFragmentManager
            .beginTransaction()
            .add(R.id.map_fragment, mapFragment)
            .commit()


        //Pesquisa e roda todos os itens da API
        places.enqueue(object : Callback<List<Places>>
        {
            override fun onFailure(call: Call<List<Places>>, t: Throwable)
            {
                Toast.makeText(comp.baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Places>>, response: Response<List<Places>>)
            {
                response.body()?.forEach {
                    mapFragment.getMapAsync{ googleMap->
                        mapsUtils.addMarkers(googleMap,
                            it.name.toString(),
                            it.subs.toString(),
                            it.lat.toString(),
                            it.lat.toString()
                        )

                        //Quando o mapa carregar completamente
                        googleMap.setOnMapLoadedCallback{

                        }
                    }
                }
            }
        })
    }
}