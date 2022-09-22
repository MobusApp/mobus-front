package com.example.mobus.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobus.R


open class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeActivity = WelcomeActivity()
        val map = MapActivity()


        //AppCompatActivity tem que ser instanciado para que as classes do map rodem
        map.loadMap(this)

    }
}





