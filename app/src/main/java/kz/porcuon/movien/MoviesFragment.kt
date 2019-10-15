package kz.porcuon.movien

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movies.*
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
        Log.d("tag", "showMovies")
        val adapter = RVMoviesAdapter(context!!, movies)
        rvMovies.visibility = View.VISIBLE
        rvMovies.layoutManager = LinearLayoutManager(context)
        rvMovies.adapter = adapter
    }

    private fun navigateToMovieDetails(movieId: Int) {
        val directions = MoviesFragmentDirections.actionMoviesFragmentToMovieDetailsFragment(movieId)
//        Navigation.findNavController(it).navigate(directions)
    }
}
