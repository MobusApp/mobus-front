package com.example.mobus.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    companion object{
        /**
         * Retorna a instância para requisições.
         *
         * Mais em: https://medium.com/@alifyzfpires/consumindo-api-rest-com-retrofit-kotlin-no-android-abba52820cc
         *
         * @param Caminho API
         */
        fun getRetrofitInstance(path: String): Retrofit.Builder {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
        }
    }
}
