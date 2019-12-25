package kz.porcuon.data.sources.network

import kz.porcuon.data.entities.TPageableEntity
import kz.porcuon.data.entities.movie.MovieDetailsEntity
import kz.porcuon.data.entities.movie.MovieEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val MOVIE_URL = "3/movie"

interface MovieApi {
    @GET("$MOVIE_URL/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): Response<TPageableEntity<MovieEntity>>

    @GET("$MOVIE_URL/{id}")
    suspend fun getMovieById(@Path("id") movieId: Int): Response<MovieDetailsEntity>
}