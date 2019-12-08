package kz.porcuon.data.di.internal

import kz.porcuon.data.sources.network.AccountApi
import kz.porcuon.data.sources.network.AuthenticationApi
import kz.porcuon.data.sources.network.MovieApi
import kz.porcuon.data.sources.network.ReviewApi
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

internal fun getModuleApi(): Module = module {
    single { get<Retrofit>().create(MovieApi::class.java) }
    single { get<Retrofit>().create(AuthenticationApi::class.java) }
    single { get<Retrofit>().create(AccountApi::class.java) }
    single { get<Retrofit>().create(ReviewApi::class.java) }
}