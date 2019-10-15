package kz.porcuon.movien

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.item_movie_card.view.*
import kz.porcuon.domain.data.MovieResponse

class RVMoviesAdapter(
    private val context: Context,
    private val movies: List<MovieResponse.Movie>
) : RecyclerView.Adapter<RVMoviesAdapter.VHMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHMovie {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie_card, parent, false)
        return VHMovie(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: VHMovie, position: Int) {
        holder.bind(movies[position])
    }

    inner class VHMovie(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieResponse.Movie) = with(itemView) {
            tvTitle.text = movie.title
            tvOverview.text = movie.overview

            Glide.with(context)
                .load(movie.posterPath)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivPoster)
        }
    }
}