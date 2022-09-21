package com.example.mobus.view




import androidx.appcompat.app.AppCompatActivity
import com.example.mobus.R

import com.example.mobus.util.*


import com.google.android.gms.maps.SupportMapFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapActivity() {

    /**
     * sem essa classe o map já aparece,
     * mas com ela podemos fazer manipuções e deixar métodos
     * assíncronos
     */
    public fun loadMap(comp: AppCompatActivity)
    {
        val mapsUtils: MapsUtils = MapsUtils()
        val app : AppUtils = AppUtils()

        //Transformando o map em um fragmento
        val mapFragment = SupportMapFragment.newInstance()
            comp.supportFragmentManager
                .beginTransaction()
                .add(R.id.map_fragment, mapFragment)
                .commit()

        //onMapReady é um método assíncrono, então ele só vai ser executado quando o mapa estiver pronto



        //cria uma rotina para listar os pontos
        val job = CoroutineScope(Dispatchers.Main).launch {
            while (true)
            {
                print("hello world é meus ovos")

                mapFragment.getMapAsync{

                    ApiUtils.getBusByLine(comp, it)
                }

                delay(1000)
            }
        }
    }
}
