package kz.porcuon.domain.use_cases

import kz.porcuon.domain.Either
import kz.porcuon.domain.Failure
import kz.porcuon.domain.Success
import kz.porcuon.domain.UseCase
import kz.porcuon.domain.data.MovieResponse
import kz.porcuon.domain.repositories.MovieRepository

class GetPopularMoviesUseCase(
    private val movieRepository: MovieRepository
) : UseCase<MovieResponse, Int>() {
    override suspend fun run(params: Int): Either<Throwable, MovieResponse> {
        return try {
            val response = movieRepository.getPopularMovies(params)
            Success(response)
        } catch (throwable: Throwable) {
            Failure(throwable)
        }
    }
}