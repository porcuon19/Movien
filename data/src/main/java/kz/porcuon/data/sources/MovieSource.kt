package kz.porcuon.data.sources

import kz.porcuon.data.di.ServiceLocator
import kz.porcuon.data.entities.toData
import kz.porcuon.data.extensions.unwrap
import kz.porcuon.domain.data.MovieFullResponse
import kz.porcuon.domain.data.MovieResponse
import kz.porcuon.domain.repositories.MovieRepository

class MovieSource : MovieRepository {

    private val movieApi = ServiceLocator.movieApi

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return movieApi.getPopularMovies(page).unwrap().toData()
    }

    override suspend fun getMovieById(movieId: Int): MovieFullResponse {
        return movieApi.getMovieById(movieId).unwrap().toData()
    }
}