package kz.porcuon.data

import kz.porcuon.data.di.ServiceLocator
import kz.porcuon.data.entities.toData
import kz.porcuon.data.extensions.unwrap
import kz.porcuon.domain.repositories.MovieRepository
import kz.porcuon.domain.data.MovieResponse

class MovieDataSource : MovieRepository {

    private val movieApi = ServiceLocator.movieApi

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return movieApi.getPopularMovies(page).unwrap().toData()
    }
}