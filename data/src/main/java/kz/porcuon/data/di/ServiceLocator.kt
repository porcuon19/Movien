package kz.porcuon.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kz.porcuon.data.configs.BASE_URL
import kz.porcuon.data.MovieApi
import kz.porcuon.data.MovieDataSource
import kz.porcuon.data.interceptors.ParamsInterceptor
import kz.porcuon.domain.repositories.MovieRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*TODO replace with DI Framework*/
object ServiceLocator {

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(ParamsInterceptor())
            .build()
    }

    private val gson: Gson by lazy {
        GsonBuilder()
            .serializeNulls()
            .create()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    val movieApi: MovieApi by lazy { retrofit.create(MovieApi::class.java) }

    val movieRepository: MovieRepository by lazy { MovieDataSource() }
}