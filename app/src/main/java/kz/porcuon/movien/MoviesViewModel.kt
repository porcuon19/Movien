package kz.porcuon.movien

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

    internal val viewState: MutableLiveData<ViewState> = MutableLiveData()

    init {
        loadItems()
        ViewState.ShowLoading
    }

    private fun handleGetPopularMoviesSuccess(movieResponse: MovieResponse) {
        if (isFirstLoad) {
            viewState.value = ViewState.HideLoading
            isFirstLoad = false
        } else {
            viewState.value = ViewState.HidePaginating
        }

        viewState.value = ViewState.ShowItems(movieResponse.results ?: ArrayList())
        page++
    }

    private fun handleGetPopularMoviesFailure(throwable: Throwable) {
        if (isFirstLoad) {
            viewState.value = ViewState.HideLoading
            isFirstLoad = false
        } else {
            viewState.value = ViewState.HidePaginating
        }
    }

    fun loadItems() {
        if (!isFirstLoad) {
            viewState.value = ViewState.ShowPaginating
        }
        scope.launch {
            getPopularMoviesUseCase(params = page,
                onSuccess = { handleGetPopularMoviesSuccess(it) },
                onFailure = { handleGetPopularMoviesFailure(it) }
            )
        }
    }
}