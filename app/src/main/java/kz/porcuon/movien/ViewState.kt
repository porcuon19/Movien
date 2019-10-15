package kz.porcuon.movien

import kz.porcuon.domain.data.MovieResponse

sealed class ViewState {
    class ShowItems(val items: List<MovieResponse.Movie>) : ViewState()

    object Loading : ViewState()
}