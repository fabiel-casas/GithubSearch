package com.fabiel.casas.networking.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
object RetrofitConfiguration {

    fun build(): Retrofit {
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(GitHubInterceptor())
            .build()
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()
    }
}