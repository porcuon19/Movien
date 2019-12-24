package kz.porcuon.movien.flow.movie_details

import kz.porcuon.domain.data.movie.MovieDetails

sealed class MovieDetailsViewState {
    object ShowLoading : MovieDetailsViewState()
    object HideLoading : MovieDetailsViewState()

    class ShowMovie(val movie: MovieDetails) : MovieDetailsViewState()
}