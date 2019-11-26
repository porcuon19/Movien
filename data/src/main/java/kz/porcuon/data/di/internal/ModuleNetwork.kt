package kz.porcuon.data.di.internal

import com.google.gson.GsonBuilder
import kz.porcuon.data.configs.BASE_URL
import kz.porcuon.data.interceptors.ParamsInterceptor
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal fun getModuleNetwork(): Module = module {
    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(ParamsInterceptor())
            .build()
    }
    single {
        GsonBuilder()
            .serializeNulls()
            .create()
    }
    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(get()))
            .baseUrl(BASE_URL)
            .client(get())
            .build()
    }
}