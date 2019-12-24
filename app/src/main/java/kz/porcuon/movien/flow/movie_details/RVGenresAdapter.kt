package kz.porcuon.movien.flow.movie_details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.vh_movie_genre.view.*
import kz.porcuon.domain.data.movie.MovieGenre
import kz.porcuon.movien.R
import kz.porcuon.movien.support.RVAbstractAdapter
import kz.porcuon.movien.support.VHAbstract

class RVGenresAdapter(
    private val context: Context,
    genres: MutableList<MovieGenre>
) : RVAbstractAdapter<MovieGenre>(genres) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHAbstract<MovieGenre> {
        val view = LayoutInflater.from(context).inflate(R.layout.vh_movie_genre, parent, false)
        return VHGenre(view)
    }

    class VHGenre(itemView: View) : VHAbstract<MovieGenre>(itemView) {
        override fun bind(model: MovieGenre) = with(itemView) {
            tvGenre.text = model.name
        }
    }
}