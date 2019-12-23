package kz.porcuon.movien.flow.movie_details

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kz.porcuon.domain.data.movie.MovieFull
import kz.porcuon.domain.use_cases.movie.GetMovieByIdUseCase
import kz.porcuon.movien.support.AbstractViewModel
import org.koin.core.inject

class MovieDetailsViewModel : AbstractViewModel() {

    private val getMovieByIdUseCase: GetMovieByIdUseCase by inject()

    val viewState: MutableLiveData<MovieDetailsViewState> = MutableLiveData()

    private fun handleGetMovieSuccess(movieFull: MovieFull) {
        viewState.value = MovieDetailsViewState.HideLoading
        viewState.value = MovieDetailsViewState.ShowMovie(movieFull)
    }

    private fun handleGetMovieFailure(throwable: Throwable) {
        /*TODO add error handling*/
    }

    fun loadMovie(movieId: Int) {
        viewState.value = MovieDetailsViewState.ShowLoading
        scope.launch { getMovieByIdUseCase(movieId, ::handleGetMovieSuccess, ::handleGetMovieFailure) }
    }
}