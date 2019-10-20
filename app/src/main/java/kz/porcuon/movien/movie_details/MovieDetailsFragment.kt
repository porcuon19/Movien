package kz.porcuon.movien.movie_details

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fragment_movie_details.*
import kz.porcuon.domain.data.MovieFullResponse
import kz.porcuon.movien.R
import kz.porcuon.movien.support.AbstractFragment
import java.text.DecimalFormat

class MovieDetailsFragment : AbstractFragment() {

    private val movieDetailsViewModel: MovieDetailsViewModel by lazy {
        ViewModelProviders.of(this).get(MovieDetailsViewModel::class.java)
    }

    private var movie: MovieFullResponse? = null

    override val layoutId: Int = R.layout.fragment_movie_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

        val movieId = arguments?.let { MovieDetailsFragmentArgs.fromBundle(it).movieId }
        movieDetailsViewModel.viewState.observe(viewLifecycleOwner, Observer { handleViewStateChange(it) })
        movieDetailsViewModel.loadMovie(movieId ?: 0)
    }

    private fun setupUI() {
        toolbar.apply {
            setNavigationOnClickListener(::onBackButtonClicked)
            setOnMenuItemClickListener(::onMenuItemClicked)
        }
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            private var scrollRange = -1
            private var isShown = false

            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout?.totalScrollRange ?: -1
                }
                if (scrollRange + verticalOffset == 0) {
                    movie?.let { toolbar.title = it.title }
                    isShown = true
                } else if (isShown) {
                    toolbar.title = " "
                    isShown = false
                }
            }
        })
    }

    private fun onBackButtonClicked(view: View) {
        Navigation.findNavController(view).popBackStack()
    }

    private fun onMenuItemClicked(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == R.id.menu_movie_share) {
            shareMovie()
            return true
        }
        return false
    }

    private fun handleViewStateChange(viewState: MovieDetailsViewState) = when (viewState) {
        is MovieDetailsViewState.ShowLoading -> showLoading()
        is MovieDetailsViewState.HideLoading -> hideLoading()
        is MovieDetailsViewState.ShowMovie -> showMovie(viewState.movie)
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    private fun showMovie(movieFullResponse: MovieFullResponse) = with(movieFullResponse) {
        movie = this
        llContent.visibility = View.VISIBLE

        Glide.with(context!!)
            .load(posterPath)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(ivPoster)

        tvOverview.text = overview
        tvRating.text = getString(R.string.movie_details_rating_holder, voteAverage.toString(), voteCount)
        tvReleaseDate.text = releaseDate
        tvBudget.text = DecimalFormat("#,###,###").format(budget)

        genres?.let {
            rvGenres.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvGenres.adapter = RVGenresAdapter(context!!, it.toMutableList())
        }
    }

    private fun shareMovie() {
        movie?.let { movie ->
            val intent = Intent(Intent.ACTION_SEND)
            val url = "https://movien.kz/${movie.id}"
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, url)
            startActivity(intent)
        }
    }
}