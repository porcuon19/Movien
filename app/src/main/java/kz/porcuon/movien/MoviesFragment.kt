package kz.porcuon.movien

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kz.porcuon.domain.data.MovieResponse

class MoviesFragment : AbstractFragment() {

    private val moviesViewModel: MoviesViewModel by lazy {
        ViewModelProviders.of(this).get(MoviesViewModel::class.java)
    }

    override val layoutId: Int = R.layout.fragment_movies

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesViewModel.viewState.observe(viewLifecycleOwner, Observer { handleViewStateChange(it) })
    }

    private fun handleViewStateChange(viewState: ViewState) = when (viewState) {
        is ViewState.Loading -> showLoading()
        is ViewState.ShowItems -> showMovies(viewState.items)
    }

    private fun showLoading() {

    }

    private fun showMovies(movies: List<MovieResponse.Movie>) {
        movies.forEach {
            Log.d("Tag", "${it.title}")
        }
    }
}
