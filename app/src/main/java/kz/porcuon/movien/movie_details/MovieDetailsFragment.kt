package kz.porcuon.movien.movie_details

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_movie_details.*
import kz.porcuon.domain.data.MovieFullResponse
import kz.porcuon.movien.R
import kz.porcuon.movien.support.AbstractFragment

class MovieDetailsFragment : AbstractFragment() {

    private val movieDetailsViewModel: MovieDetailsViewModel by lazy {
        ViewModelProviders.of(this).get(MovieDetailsViewModel::class.java)
    }

    override val layoutId: Int = R.layout.fragment_movie_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

        val movieId = arguments?.let { MovieDetailsFragmentArgs.fromBundle(it).movieId }
        movieDetailsViewModel.viewState.observe(viewLifecycleOwner, Observer { handleViewStateChange(it) })
        movieDetailsViewModel.loadMovie(movieId ?: 0) // TODO better implementation?
    }

    private fun setupUI() {
        toolbar.apply {
            setNavigationOnClickListener(::onBackButtonClicked)
            setOnMenuItemClickListener(::onMenuItemClicked)
        }
    }

    private fun onBackButtonClicked(view: View) {
        Navigation.findNavController(view).popBackStack()
    }

    private fun onMenuItemClicked(menuItem: MenuItem) = when (menuItem.itemId) {
        R.id.menu_movie_share -> {
            Log.d("TAG", "on share clicked")
            true
        }
        else -> false
    }

    private fun handleViewStateChange(viewState: MovieDetailsViewState) = when (viewState) {
        is MovieDetailsViewState.ShowLoading -> showLoading()
        is MovieDetailsViewState.HideLoading -> hideLoading()
        is MovieDetailsViewState.ShowMovie -> showMovie(viewState.movie)
    }

    private fun showLoading() {

    }

    private fun hideLoading() {

    }

    private fun showMovie(movie: MovieFullResponse) {

    }

    private fun shareMovie() {

    }
}