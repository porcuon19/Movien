package kz.porcuon.domain.use_cases.movie

import kz.porcuon.domain.data.movie.MovieDetails
import kz.porcuon.domain.functional.Either
import kz.porcuon.domain.functional.Failure
import kz.porcuon.domain.functional.Success
import kz.porcuon.domain.repositories.MovieRepository
import kz.porcuon.domain.use_cases.UseCase

class GetMovieByIdUseCase(
    private val movieRepository: MovieRepository
) : UseCase<MovieDetails, Int>() {
    override suspend fun run(params: Int): Either<Throwable, MovieDetails> {
        return try {
            val response = movieRepository.getMovieById(params)
            Success(response)
        } catch (throwable: Throwable) {
            Failure(throwable)
        }
    }
}