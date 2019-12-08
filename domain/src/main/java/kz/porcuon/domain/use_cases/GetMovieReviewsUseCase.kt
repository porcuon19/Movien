package kz.porcuon.domain.use_cases

import kz.porcuon.domain.data.review.ReviewResponse
import kz.porcuon.domain.functional.Either
import kz.porcuon.domain.functional.Failure
import kz.porcuon.domain.functional.Success
import kz.porcuon.domain.repositories.ReviewRepository

class GetMovieReviewsUseCase(
    private val reviewRepository: ReviewRepository
) : UseCase<ReviewResponse, Int>() {
    override suspend fun run(params: Int): Either<Throwable, ReviewResponse> {
        return try {
            val response = reviewRepository.getMovieReviews(params)
            Success(response)
        } catch (throwable: Throwable) {
            Failure(throwable)
        }
    }
}