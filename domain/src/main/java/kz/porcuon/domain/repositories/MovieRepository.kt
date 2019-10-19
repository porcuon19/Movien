package kz.porcuon.domain.repositories

import kz.porcuon.domain.data.MovieFullResponse
import kz.porcuon.domain.data.MovieResponse

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): MovieResponse

    suspend fun getMovieById(movieId: Int): MovieFullResponse
}