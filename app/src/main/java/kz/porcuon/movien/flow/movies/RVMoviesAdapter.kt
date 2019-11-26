package kz.porcuon.movien.flow.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.vh_movie_card.view.*
import kz.porcuon.domain.data.movie.MovieResponse
import kz.porcuon.movien.R
import kz.porcuon.movien.support.RVPageableAdapter
import kz.porcuon.movien.support.VHAbstract

class RVMoviesAdapter(
    private val context: Context,
    private val onMovieClicked: (View, Int) -> Unit,
    private val onShareClicked: (Int) -> Unit,
    movies: MutableList<MovieResponse.Movie>
) : RVPageableAdapter<MovieResponse.Movie>(movies) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHAbstract<MovieResponse.Movie> {
        val view = LayoutInflater.from(context).inflate(viewType, parent, false)
        return when(viewType) {
            R.layout.vh_loader -> VHLoader(view)
            R.layout.vh_movie_card -> VHMovie(view)
            else -> throw NoSuchElementException()
        }
    }

    override fun getItemViewType(position: Int) = when {
        (position == items.size - 1 && isLoaderVisible) -> R.layout.vh_loader
        else -> R.layout.vh_movie_card
    }

    inner class VHMovie(itemView: View) : VHAbstract<MovieResponse.Movie>(itemView) {
        override fun bind(model: MovieResponse.Movie) = with(itemView) {
            tvTitle.text = model.title
            tvOverview.text = model.overview
            tvRating.text = model.voteAverage.toString()

            Glide.with(context)
                .load(model.posterPath)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivPoster)

            ivShare.setOnClickListener { onShareClicked(model.id ?: 0) }

            setOnClickListener { onMovieClicked(it, model.id ?: 0) }
        }
    }

    inner class VHLoader(itemView: View) : VHAbstract<MovieResponse.Movie>(itemView) {
        override fun bind(model: MovieResponse.Movie) { }
    }
}