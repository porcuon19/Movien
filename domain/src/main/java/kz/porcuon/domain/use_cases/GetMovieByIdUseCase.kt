package kz.porcuon.domain.use_cases

import kz.porcuon.domain.Either
import kz.porcuon.domain.Failure
import kz.porcuon.domain.Success
import kz.porcuon.domain.UseCase
import kz.porcuon.domain.data.MovieFullResponse
import kz.porcuon.domain.repositories.MovieRepository

class GetMovieByIdUseCase(
    private val movieRepository: MovieRepository
) : UseCase<MovieFullResponse, Int>() {
    override suspend fun run(params: Int): Either<Throwable, MovieFullResponse> {
        return try {
            val response = movieRepository.getMovieById(params)
            Success(response)
        } catch (throwable: Throwable) {
            Failure(throwable)
        }
    }
}