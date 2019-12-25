package kz.porcuon.movien.flow.movies

import kz.porcuon.domain.data.movie.Movie

/*TODO add error states*/
sealed class MoviesViewState {
    object ShowLoading : MoviesViewState()
    object ShowPaginating : MoviesViewState()
    object HidePaginating : MoviesViewState()
    object HideLoading : MoviesViewState()

    class ShowMovies(val movies: List<Movie>) : MoviesViewState()
}