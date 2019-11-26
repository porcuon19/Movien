package kz.porcuon.data.repositories

import kz.porcuon.data.entities.movie.toData
import kz.porcuon.data.extensions.unwrap
import kz.porcuon.data.sources.network.MovieApi
import kz.porcuon.domain.data.movie.MovieFull
import kz.porcuon.domain.data.movie.MovieResponse
import kz.porcuon.domain.repositories.MovieRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class BaseMovieRepository : MovieRepository, KoinComponent {

    private val movieApi: MovieApi by inject()

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return movieApi.getPopularMovies(page).unwrap().toData()
    }

    override suspend fun getMovieById(movieId: Int): MovieFull {
        return movieApi.getMovieById(movieId).unwrap().toData()
    }
}