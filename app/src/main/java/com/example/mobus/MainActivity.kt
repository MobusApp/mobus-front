package com.example.mobus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


open class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val map : MapActivity = MapActivity()
        //Eu confesso que não sei muito o porque ele pediu esse this...
        //Mas que o AppCompatActivity tem que ser instanciado para que as classes
        //do map rodem, por enquanto, está assim para testes.
        map.loadMap(this)

    }
}





