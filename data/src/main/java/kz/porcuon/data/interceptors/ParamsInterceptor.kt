package kz.porcuon.data.interceptors

import kz.porcuon.data.configs.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

private const val PARAM_API_KEY = "api_key"

class ParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val urlBuilder = request.url().newBuilder()
        val url = urlBuilder.addQueryParameter(PARAM_API_KEY, API_KEY).build()
        val requestBuilder = request.newBuilder().url(url)

        return chain.proceed(requestBuilder.build())
    }
}