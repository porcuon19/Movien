package kz.porcuon.movien.flow.movies

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kz.porcuon.domain.data.movie.MovieResponse
import kz.porcuon.domain.use_cases.GetPopularMoviesUseCase
import kz.porcuon.movien.support.AbstractViewModel
import org.koin.core.inject

class MoviesViewModel : AbstractViewModel() {

    private val getPopularMoviesUseCase: GetPopularMoviesUseCase by inject()

    private var page = 1

    private var isFirstLoad = true

    val viewState: MutableLiveData<MoviesViewState> = MutableLiveData()

    init {
        loadMovies()
        viewState.value = MoviesViewState.ShowLoading
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
        scope.launch {
            getPopularMoviesUseCase(
                page,
                ::handleGetPopularMoviesSuccess,
                ::handleGetPopularMoviesFailure
            )
        }
    }
}