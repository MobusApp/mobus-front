package com.example.mobus.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobus.R
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main


open class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val map : MapActivity = MapActivity()


        //AppCompatActivity tem que ser instanciado para que as classes do map rodem
        map.loadMap(this)

    }
}





