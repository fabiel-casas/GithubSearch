package com.fabiel.casas.networking.http

import okhttp3.Interceptor
import okhttp3.Response

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
class GitHubInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Authorization", "Bearer REPLACE_YOUR_TOKEN_HERE!!!!")
        return chain.proceed(builder.build())
    }
}