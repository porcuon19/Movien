package kz.porcuon.movien.flow.reviews

import kz.porcuon.domain.data.review.Review

sealed class ReviewsViewState {
    object HideLoading : ReviewsViewState()
    object ShowEmptyReviews : ReviewsViewState()

    class ShowReviews(val reviews: List<Review>) : ReviewsViewState()
}