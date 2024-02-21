package com.senai.gws_kotlin.apis

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitConfig {
    companion object{
//        fun obterInstanciaRetrofit(url: String = "http://172.16.26.36:8080/") : Retrofit{
//
//
//
//            return Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }

        fun create(): Retrofit {

            val client = OkHttpClient.Builder()
                .readTimeout(60,TimeUnit.SECONDS)
                .build()


            return Retrofit.Builder()
                .baseUrl("http://172.16.26.36:8080/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    }
