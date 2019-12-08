package kz.porcuon.data.sources.network

import kz.porcuon.data.entities.movie.MovieFullEntity
import kz.porcuon.data.entities.movie.MovieResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val MOVIE_URL = "3/movie"

interface MovieApi {
    @GET("$MOVIE_URL/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): Response<MovieResponseEntity>

    @GET("$MOVIE_URL/{id}")
    suspend fun getMovieById(@Path("id") movieId: Int): Response<MovieFullEntity>
}