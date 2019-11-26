package kz.porcuon.movien.flow.movie_details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.vh_movie_genre.view.*
import kz.porcuon.domain.data.movie.MovieFull
import kz.porcuon.movien.R
import kz.porcuon.movien.support.RVAbstractAdapter
import kz.porcuon.movien.support.VHAbstract

class RVGenresAdapter(
    private val context: Context,
    genres: MutableList<MovieFull.Genre>
) : RVAbstractAdapter<MovieFull.Genre>(genres) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHAbstract<MovieFull.Genre> {
        val view = LayoutInflater.from(context).inflate(R.layout.vh_movie_genre, parent, false)
        return VHGenre(view)
    }

    class VHGenre(itemView: View) : VHAbstract<MovieFull.Genre>(itemView) {
        override fun bind(model: MovieFull.Genre) = with(itemView) {
            tvGenre.text = model.name
        }
    }
}