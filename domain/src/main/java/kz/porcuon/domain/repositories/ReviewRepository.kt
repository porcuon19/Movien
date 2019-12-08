package kz.porcuon.domain.repositories

import kz.porcuon.domain.data.review.ReviewResponse

interface ReviewRepository {
    suspend fun getMovieReviews(movieId: Int): ReviewResponse
}