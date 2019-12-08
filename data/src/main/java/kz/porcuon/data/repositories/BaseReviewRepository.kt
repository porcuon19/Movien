package kz.porcuon.data.repositories

import kz.porcuon.data.entities.review.toData
import kz.porcuon.data.extensions.unwrap
import kz.porcuon.data.sources.network.ReviewApi
import kz.porcuon.domain.data.review.ReviewResponse
import kz.porcuon.domain.repositories.ReviewRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class BaseReviewRepository : ReviewRepository, KoinComponent {

    private val reviewApi: ReviewApi by inject()

    override suspend fun getMovieReviews(movieId: Int): ReviewResponse {
        return reviewApi.getMovieReviews(movieId).unwrap().toData()
    }
}