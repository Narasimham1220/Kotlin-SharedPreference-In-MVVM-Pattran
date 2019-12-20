package com.example.sampletask

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("search/users")
    fun search(@Query("q") query: String, @Query("page") page: Int)

    /**
     * Factory class for convenient creation of the Api Service interface
     */
    class Factory {

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build()

            return retrofit.create<ApiService>(ApiService::class.java)
        }
    }
}