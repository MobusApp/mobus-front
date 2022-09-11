package com.example.mobus.controle

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Classe de retorno de locais
 * @lat = latitude
 * @long = logitura
 * @name = nome do local
 * @subs = Descrição do local
 */
class Places
{
    @SerializedName("lat")
    @Expose
    var lat: String? = null

    @SerializedName("long")
    @Expose
    var long: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("subs")
    @Expose
    var subs: String? = null
}

class Auth
{

}