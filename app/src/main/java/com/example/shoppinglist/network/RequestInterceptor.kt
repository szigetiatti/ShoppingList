package com.example.shoppinglist.network

import com.example.shoppinglist.Utility.print
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        request.toString().print()
        return chain.proceed(request)
    }
}