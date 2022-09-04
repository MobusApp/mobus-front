package com.example.mobus.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET



/**
 * Estou testando com a API pública:
 * https://jsonplaceholder.typicode.com
 *
 *  /todos
 */
interface Endpoint {

    @GET('/todos')
    fun getTodos() : Call<List<Todos>>

}