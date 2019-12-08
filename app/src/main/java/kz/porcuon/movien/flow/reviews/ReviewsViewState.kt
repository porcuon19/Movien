package kz.porcuon.movien.flow.reviews

import kz.porcuon.domain.data.review.ReviewResponse

sealed class ReviewsViewState {
    object HideLoading : ReviewsViewState()

    class ShowReviews(val reviews: List<ReviewResponse.Review>) : ReviewsViewState()
}