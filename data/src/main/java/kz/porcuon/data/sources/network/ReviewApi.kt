package kz.porcuon.data.sources.network

import kz.porcuon.data.entities.TPageableEntity
import kz.porcuon.data.entities.review.ReviewEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val REVIEW_URL = "3/movie"

interface ReviewApi {
    @GET("$REVIEW_URL/{id}/reviews")
    suspend fun getMovieReviews(@Path("id") movieId: Int): Response<TPageableEntity<ReviewEntity>>
}