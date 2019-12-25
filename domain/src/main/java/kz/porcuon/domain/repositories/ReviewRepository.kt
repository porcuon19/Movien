package kz.porcuon.domain.repositories

import kz.porcuon.domain.data.review.Review

interface ReviewRepository {
    suspend fun getMovieReviews(movieId: Int): List<Review>
}