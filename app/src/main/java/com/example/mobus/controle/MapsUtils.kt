package com.example.mobus.controle


import com.example.mobus.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


/**
 * Utilitários para o maps
 */
class MapsUtils constructor()
{
    //Função que devolve as marcações para colocar no mapa
    public fun addMarkers(googlemap :GoogleMap, nome: String, descricao: String, latitude: String, longitude: String)
    {
        //Chama o Icone - Mais simples que criar um vetor....
        //todo - alterar para usar um vetor, por ser melhor de manipualar - Criar um método para isso
        val icone = BitmapDescriptorFactory.fromResource(R.drawable.amoung)

        val marker = googlemap.addMarker(
            MarkerOptions()
                .title(nome)
                .snippet(descricao)
                .position(formatLatLog(latitude,longitude))
                .icon(icone)
       )
    }

    //Adiciona uma rota entre dois pontos
    public fun addRoute()
    {

    }

    //Verificar duas Strings de coordenadas e devolve p formato para objeto addMarker
    private fun formatLatLog(latitude:String, longitude:String): LatLng
    {
        return LatLng(latitude.toDouble(),longitude.toDouble())
    }

}
