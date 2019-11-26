package kz.porcuon.data.interceptors

import kz.porcuon.data.configs.API_KEY
import kz.porcuon.data.sources.preferences.getSessionId
import okhttp3.Interceptor
import okhttp3.Response

private const val PARAM_API_KEY = "api_key"
private const val PARAM_SESSION_ID = "session_id"

class ParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val urlBuilder = request.url().newBuilder()

        getSessionId()?.let {
            urlBuilder.addQueryParameter(PARAM_SESSION_ID, it)
        }

        val url = urlBuilder
            .addQueryParameter(PARAM_API_KEY, API_KEY)
            .build()
        val requestBuilder = request.newBuilder().url(url)

        return chain.proceed(requestBuilder.build())
    }
}