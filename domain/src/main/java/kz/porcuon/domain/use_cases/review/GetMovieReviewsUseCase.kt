package kz.porcuon.domain.use_cases.review

import kz.porcuon.domain.data.review.Review
import kz.porcuon.domain.functional.Either
import kz.porcuon.domain.functional.Failure
import kz.porcuon.domain.functional.Success
import kz.porcuon.domain.repositories.ReviewRepository
import kz.porcuon.domain.use_cases.UseCase

class GetMovieReviewsUseCase(
    private val reviewRepository: ReviewRepository
) : UseCase<List<Review>, Int>() {
    override suspend fun run(params: Int): Either<Throwable, List<Review>> {
        return try {
            val response = reviewRepository.getMovieReviews(params)
            Success(response)
        } catch (throwable: Throwable) {
            Failure(throwable)
        }
    }
}