package kz.porcuon.movien.movies

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kz.porcuon.data.di.ServiceLocator
import kz.porcuon.domain.data.MovieResponse
import kz.porcuon.domain.use_cases.GetPopularMoviesUseCase
import kz.porcuon.movien.support.AbstractViewModel

class MoviesViewModel : AbstractViewModel() {

    private var page = 1

    private var isFirstLoad = true

    private val getPopularMoviesUseCase = GetPopularMoviesUseCase(ServiceLocator.movieRepository)

    internal val viewState: MutableLiveData<MoviesViewState> = MutableLiveData()

    init {
        loadMovies()
        MoviesViewState.ShowLoading
    }

    private fun handleGetPopularMoviesSuccess(movieResponse: MovieResponse) {
        if (isFirstLoad) {
            viewState.value = MoviesViewState.HideLoading
            isFirstLoad = false
        } else {
            viewState.value = MoviesViewState.HidePaginating
        }

        viewState.value = MoviesViewState.ShowMovies(movieResponse.results ?: ArrayList())
        page++
    }

    /*TODO add proper error handling*/
    private fun handleGetPopularMoviesFailure(throwable: Throwable) {
        if (isFirstLoad) {
            viewState.value = MoviesViewState.HideLoading
            isFirstLoad = false
        } else {
            viewState.value = MoviesViewState.HidePaginating
        }
    }

    fun loadMovies() {
        if (!isFirstLoad) {
            viewState.value = MoviesViewState.ShowPaginating
        }
        scope.launch { getPopularMoviesUseCase(page, ::handleGetPopularMoviesSuccess, ::handleGetPopularMoviesFailure) }
    }
}