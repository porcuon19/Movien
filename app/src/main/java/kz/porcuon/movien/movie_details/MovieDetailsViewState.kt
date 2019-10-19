package kz.porcuon.movien.movie_details

import kz.porcuon.domain.data.MovieFullResponse

sealed class MovieDetailsViewState {
    object ShowLoading : MovieDetailsViewState()
    object HideLoading : MovieDetailsViewState()

    class ShowMovie(val movie: MovieFullResponse) : MovieDetailsViewState()
}