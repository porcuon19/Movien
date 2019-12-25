package kz.porcuon.domain.repositories

import kz.porcuon.domain.data.movie.Movie
import kz.porcuon.domain.data.movie.MovieDetails

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): List<Movie>

    suspend fun getMovieById(movieId: Int): MovieDetails
}