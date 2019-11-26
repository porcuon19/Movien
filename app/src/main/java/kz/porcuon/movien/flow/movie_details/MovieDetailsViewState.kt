package kz.porcuon.movien.flow.movie_details

import kz.porcuon.domain.data.movie.MovieFull

sealed class MovieDetailsViewState {
    object ShowLoading : MovieDetailsViewState()
    object HideLoading : MovieDetailsViewState()

    class ShowMovie(val movie: MovieFull) : MovieDetailsViewState()
}