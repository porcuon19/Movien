package kz.porcuon.domain.repositories

import kz.porcuon.domain.data.movie.MovieDetails
import kz.porcuon.domain.data.movie.MovieResponse

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): MovieResponse

    suspend fun getMovieById(movieId: Int): MovieDetails
}