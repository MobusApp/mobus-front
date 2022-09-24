package com.example.mobus.view


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.mobus.R
import com.example.mobus.util.ApiUtils
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


open class MainActivity : AppCompatActivity(), OnMapReadyCallback
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)


   }

    override fun onMapReady(googleMap: GoogleMap)
    {
        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        googleMap.isTrafficEnabled = true

        //passando a "tela-atual" para caso erro ele possa mostar uma mensagem
        var comp = this

        lifecycleScope.launch() {
            while (true)
            {
                delay(100)
                ApiUtils.getBusByLine(comp, googleMap)
            }
        }

    }
}





