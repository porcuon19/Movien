package kz.porcuon.movien.movie_details

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kz.porcuon.data.di.ServiceLocator
import kz.porcuon.domain.data.MovieFullResponse
import kz.porcuon.domain.use_cases.GetMovieByIdUseCase
import kz.porcuon.movien.support.AbstractViewModel

class MovieDetailsViewModel : AbstractViewModel() {

    private val getMovieByIdUseCase = GetMovieByIdUseCase(ServiceLocator.movieRepository)

    internal val viewState: MutableLiveData<MovieDetailsViewState> = MutableLiveData()

    private fun handleGetMovieSuccess(movieFullResponse: MovieFullResponse) {
        viewState.value = MovieDetailsViewState.HideLoading
        viewState.value = MovieDetailsViewState.ShowMovie(movieFullResponse)
    }

    private fun handleGetMovieFailure(throwable: Throwable) {
        /*TODO add error handling*/
    }

    fun loadMovie(movieId: Int) {
        viewState.value = MovieDetailsViewState.ShowLoading
        scope.launch { getMovieByIdUseCase(movieId, ::handleGetMovieSuccess, ::handleGetMovieFailure) }
    }
}