package kz.porcuon.movien

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kz.porcuon.data.di.ServiceLocator
import kz.porcuon.domain.data.MovieResponse
import kz.porcuon.domain.use_cases.GetPopularMoviesUseCase

class MoviesViewModel : AbstractViewModel() {

    private val getPopularMoviesUseCase = GetPopularMoviesUseCase(ServiceLocator.movieRepository)

    private val page = 1

    val viewState: MutableLiveData<ViewState> = MutableLiveData()

    init {
        loadItems()
    }

    private fun loadItems() {
        viewState.value = ViewState.Loading
        scope.launch {
            getPopularMoviesUseCase(
                params = page,
                onSuccess = { handleGetPopularMoviesSuccess(it) },
                onFailure = { handleGetPopularMoviesFailure(it) }
            )
        }
    }

    private fun handleGetPopularMoviesSuccess(movieResponse: MovieResponse) {
        viewState.value = ViewState.ShowItems(movieResponse.results ?: ArrayList())
    }

    private fun handleGetPopularMoviesFailure(throwable: Throwable) {

    }
}