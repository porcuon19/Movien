package kz.porcuon.data.di.external

import kz.porcuon.data.repositories.BaseAccountRepository
import kz.porcuon.data.repositories.BaseAuthenticationRepository
import kz.porcuon.data.repositories.BaseMovieRepository
import kz.porcuon.data.repositories.BaseReviewRepository
import kz.porcuon.domain.repositories.AccountRepository
import kz.porcuon.domain.repositories.AuthenticationRepository
import kz.porcuon.domain.repositories.MovieRepository
import kz.porcuon.domain.repositories.ReviewRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun getModuleRepository(): Module = module {
    single<MovieRepository> { BaseMovieRepository() }
    single<AuthenticationRepository> { BaseAuthenticationRepository() }
    single<AccountRepository> { BaseAccountRepository() }
    single<ReviewRepository> { BaseReviewRepository() }
}