package com.example.mobus.util


import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import com.example.mobus.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


/**
 * Utilitários para o maps
 */
class MapsUtils
{
    companion object
    {

        //create a var marker
        var markerOne: Marker? = null

        //create list os markers
        var markerMany: MutableList<Marker> = mutableListOf()

        //Função que devolve as marcações para colocar no mapa
        public fun addOneMarker(googlemap: GoogleMap, nome: String, descricao: String, latitude: String, longitude: String)
        {
            val icone = BitmapDescriptorFactory.fromResource(R.drawable.amoung)

            val markerOptions = MarkerOptions()
                .position(formatLatLog(latitude.toString(), longitude.toString()))
                .title(nome)
                .snippet(descricao)
                .icon(icone)

            //o pulo do gato
            if(markerOne != null)
            {
                markerOne!!.remove()
            }
            markerOne = googlemap.addMarker(markerOptions)
        }

        public fun addManyMarkers(googlemap: GoogleMap, nome: String, descricao: String, latitude: String, longitude: String)
        {
            val icone = BitmapDescriptorFactory.fromResource(R.drawable.amoung)

            val markerOptions = MarkerOptions()
                .position(formatLatLog(latitude.toString(), longitude.toString()))
                .title(nome)
                .snippet(descricao)
                .icon(icone)

            //o pulo do gato
            markerMany.add(googlemap.addMarker(markerOptions)!!)
        }


        /**
         * Retorna o local que nos encontramos no momento
         *
         * comp seria a main activity e o objeto é o google map instanciado
         */
        public fun returnCurrentLocation(comp: AppCompatActivity, googlemap: GoogleMap): Location {
            val map = googlemap
            val fusedLocationClient: FusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(comp)
            var location = Location("")

            //Verifica se existe a permissão para o GPS - se não existir, pede
            //todo - verificar se é necessário pedir a permissão aqui
            if (comp.checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                googlemap.uiSettings.isMyLocationButtonEnabled = true
                googlemap.isMyLocationEnabled = true

                fusedLocationClient.lastLocation.addOnSuccessListener(comp) { loc ->
                    if (loc != null) {
                        val currentLocation = LatLng(loc.latitude, loc.longitude)
                        map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f))
                    }
                }

            } else {
                comp.requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    1)
            }

            return location
        }


        //Adiciona uma rota entre dois pontos
        public fun addRoute(googlemap: GoogleMap) {

        }


        //Calcula a distancia entre dois pontos
        public fun calcPoints() {

        }


        //Emite um alerta quando o ônibus estiver proxímo
        public fun alertProximity() {

        }


        //Apróxima a câmera para o ponto
        public fun zoomProximity(googlemap: GoogleMap, latitude: String, longitude: String) {
            googlemap.moveCamera(CameraUpdateFactory.newLatLngZoom(formatLatLog(latitude,
                longitude), 15f))
        }


        //Verificar duas Strings de coordenadas e devolve p formato para objeto addMarker
        private fun formatLatLog(latitude: String, longitude: String): LatLng {
            return LatLng(latitude.toDouble(), longitude.toDouble())
        }

    }
}
