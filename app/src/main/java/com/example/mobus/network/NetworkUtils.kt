package com.example.mobus.network


import com.example.mobus.model.Endpoint
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class NetworkUtils
{

    //NOTA: companion seria o mesmo que definir como abstrato nesta linguágem :)
    companion object
    {
        /**
         * Retorna uma Instância do Client Retrofit para Requisições
         * @param path Caminho Principal da API
         */
        fun getRetrofitInstance(path: String): Endpoint
        {
            var retrofit = Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Endpoint::class.java)

            return retrofit
        }


    }
}

