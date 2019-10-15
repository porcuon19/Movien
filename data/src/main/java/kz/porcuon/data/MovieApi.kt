package kz.porcuon.data

import kz.porcuon.data.entities.MovieResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("3/movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): Response<MovieResponseEntity>
}