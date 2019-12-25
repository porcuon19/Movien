package kz.porcuon.data.repositories

import kz.porcuon.data.entities.review.ReviewEntity
import kz.porcuon.data.entities.review.toData
import kz.porcuon.data.extensions.unwrap
import kz.porcuon.data.sources.network.ReviewApi
import kz.porcuon.domain.data.review.Review
import kz.porcuon.domain.repositories.ReviewRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class BaseReviewRepository : ReviewRepository, KoinComponent {

    private val reviewApi: ReviewApi by inject()

    override suspend fun getMovieReviews(movieId: Int): List<Review> {
        return reviewApi.getMovieReviews(movieId).unwrap().results.map(ReviewEntity::toData)
    }
}