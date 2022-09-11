package com.example.mobus.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BusDTO
{
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("macAddress")
    @Expose
    var macAddress: String? = null

    @SerializedName("busLine")
    @Expose
    var busLine: String? = null

    @SerializedName("latitude")
    @Expose
    var latitude: String? = null

    @SerializedName("longitude")
    @Expose
    var longitude: String? = null
}