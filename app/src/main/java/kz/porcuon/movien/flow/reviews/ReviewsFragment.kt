package kz.porcuon.movien.flow.reviews

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_reviews.*
import kz.porcuon.domain.data.review.ReviewResponse
import kz.porcuon.movien.R
import kz.porcuon.movien.flow.movie_details.MovieDetailsFragmentArgs
import kz.porcuon.movien.support.AbstractFragment

class ReviewsFragment : AbstractFragment() {

    private val reviewsViewModel: ReviewsViewModel by lazy {
        ViewModelProviders.of(this).get(ReviewsViewModel::class.java)
    }

    private val adapter: RVReviewsAdapter by lazy {
        RVReviewsAdapter(context!!, mutableListOf())
    }

    override val layoutId = R.layout.fragment_reviews

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

        val movieId = arguments?.let { MovieDetailsFragmentArgs.fromBundle(it).movieId }
        reviewsViewModel.viewState.observe(
            viewLifecycleOwner,
            Observer { handleViewStateChange(it) })
        movieId?.let { reviewsViewModel.loadReviews(it) }
    }

    private fun setupUI() {
        toolbar.setNavigationOnClickListener(::onBackButtonClicked)
        rvReviews.layoutManager = LinearLayoutManager(context)
        rvReviews.adapter = adapter
    }

    private fun handleViewStateChange(viewState: ReviewsViewState) = when (viewState) {
        is ReviewsViewState.HideLoading -> hideLoading()
        is ReviewsViewState.ShowReviews -> showReviews(viewState.reviews)
    }

    private fun hideLoading() {
        pbReviewsLoad.visibility = View.GONE
        rvReviews.visibility = View.VISIBLE
    }

    private fun showReviews(reviews: List<ReviewResponse.Review>) {
        adapter.addItems(reviews.toMutableList())
    }

    private fun onBackButtonClicked(view: View) {
        Navigation.findNavController(view).popBackStack()
    }
}