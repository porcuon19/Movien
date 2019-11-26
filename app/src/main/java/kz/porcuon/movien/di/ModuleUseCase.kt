package kz.porcuon.movien.di

import kz.porcuon.domain.use_cases.GetMovieByIdUseCase
import kz.porcuon.domain.use_cases.GetPopularMoviesUseCase
import kz.porcuon.domain.use_cases.LoginUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getModuleUseCase(): Module = module {
    factory { GetMovieByIdUseCase(get()) }
    factory { GetPopularMoviesUseCase(get()) }
    factory { LoginUseCase(get()) }
}