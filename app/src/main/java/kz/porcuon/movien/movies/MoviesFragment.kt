package kz.porcuon.movien.movies

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movies.*
import kz.porcuon.domain.data.MovieResponse
import kz.porcuon.movien.HomeFragmentDirections
import kz.porcuon.movien.R
import kz.porcuon.movien.support.AbstractFragment
import kz.porcuon.movien.support.PaginationScrollListener

class MoviesFragment : AbstractFragment() {

    private val moviesViewModel: MoviesViewModel by lazy {
        ViewModelProviders.of(this).get(MoviesViewModel::class.java)
    }

    private val adapter: RVMoviesAdapter by lazy {
        RVMoviesAdapter(context!!, ::navigateToMovieDetails, ::shareMovieUrl, mutableListOf())
    }

    private var isPaginating = false

    override val layoutId: Int = R.layout.fragment_movies

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        moviesViewModel.viewState.observe(
            viewLifecycleOwner,
            Observer { handleViewStateChange(it) })
    }

    private fun setupUI() {
        val layoutManager = LinearLayoutManager(context)
        rvMovies.layoutManager = layoutManager
        rvMovies.adapter = adapter
        rvMovies.addOnScrollListener(object : PaginationScrollListener(layoutManager) {
            override fun isLoading() = isPaginating

            override fun loadItems() {
                moviesViewModel.loadMovies()
            }
        })
    }

    private fun handleViewStateChange(viewState: MoviesViewState) = when (viewState) {
        is MoviesViewState.ShowLoading -> showLoading()
        is MoviesViewState.HideLoading -> hideLoading()
        is MoviesViewState.ShowPaginating -> showPaginating()
        is MoviesViewState.HidePaginating -> hidePaginating()
        is MoviesViewState.ShowMovies -> showMovies(viewState.movies)
    }

    private fun showLoading() {
        flShimmer.visibility = View.VISIBLE
        flShimmer.startShimmer()
    }

    private fun hideLoading() {
        flShimmer.visibility = View.GONE
        flShimmer.stopShimmer()
    }

    private fun showPaginating() {
        isPaginating = true
        adapter.addLoader()
    }

    private fun hidePaginating() {
        isPaginating = false
        adapter.removeLoader()
    }

    private fun showMovies(movies: List<MovieResponse.Movie>) {
        rvMovies.visibility = View.VISIBLE
        adapter.addItems(movies.toMutableList())
    }

    private fun navigateToMovieDetails(view: View, movieId: Int) {
        val directions = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(movieId)
        Navigation.findNavController(view).navigate(directions)
    }

    private fun shareMovieUrl(movieId: Int) {
        val intent = Intent(Intent.ACTION_SEND)
        val url = "https://movien.kz/$movieId"
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, url)
        startActivity(intent)
    }
}
