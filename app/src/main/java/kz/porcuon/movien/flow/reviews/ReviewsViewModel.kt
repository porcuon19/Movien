package kz.porcuon.movien.flow.reviews

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kz.porcuon.domain.data.review.ReviewResponse
import kz.porcuon.domain.use_cases.GetMovieReviewsUseCase
import kz.porcuon.movien.support.AbstractViewModel
import org.koin.core.inject

class ReviewsViewModel : AbstractViewModel() {

    private val getMovieReviewsUseCase: GetMovieReviewsUseCase by inject()

    val viewState: MutableLiveData<ReviewsViewState> = MutableLiveData()

    private fun handleLoadReviewsSuccess(reviewResponse: ReviewResponse) {
        viewState.value = ReviewsViewState.HideLoading
        viewState.value = ReviewsViewState.ShowReviews(reviewResponse.results ?: ArrayList())
    }

    private fun handleLoadReviewsFailure(throwable: Throwable) {
        viewState.value = ReviewsViewState.HideLoading
    }

    fun loadReviews(movieId: Int) {
        scope.launch {
            getMovieReviewsUseCase(
                movieId,
                ::handleLoadReviewsSuccess,
                ::handleLoadReviewsFailure
            )
        }
    }
}