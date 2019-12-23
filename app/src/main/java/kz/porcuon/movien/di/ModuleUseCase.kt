package kz.porcuon.movien.di

import kz.porcuon.domain.use_cases.account.GetAccountDetailsUseCase
import kz.porcuon.domain.use_cases.account.SaveAccountDetailsUseCase
import kz.porcuon.domain.use_cases.auth.LoginUseCase
import kz.porcuon.domain.use_cases.auth.LogoutUseCase
import kz.porcuon.domain.use_cases.movie.GetMovieByIdUseCase
import kz.porcuon.domain.use_cases.movie.GetPopularMoviesUseCase
import kz.porcuon.domain.use_cases.review.GetMovieReviewsUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getModuleUseCase(): Module = module {
    factory { GetMovieByIdUseCase(get()) }
    factory { GetPopularMoviesUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { GetMovieReviewsUseCase(get()) }
    factory { SaveAccountDetailsUseCase(get()) }
    factory { GetAccountDetailsUseCase(get()) }
    factory { LogoutUseCase(get(), get()) }
}