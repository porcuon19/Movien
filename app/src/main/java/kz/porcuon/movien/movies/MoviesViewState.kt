package kz.porcuon.movien.movies

import kz.porcuon.domain.data.MovieResponse

/*TODO add error states*/
sealed class MoviesViewState {
    object ShowLoading : MoviesViewState()
    object ShowPaginating : MoviesViewState()
    object HidePaginating : MoviesViewState()
    object HideLoading : MoviesViewState()

    class ShowMovies(val movies: List<MovieResponse.Movie>) : MoviesViewState()
}