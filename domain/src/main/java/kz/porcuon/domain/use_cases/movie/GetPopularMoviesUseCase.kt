package kz.porcuon.domain.use_cases.movie

import kz.porcuon.domain.data.movie.Movie
import kz.porcuon.domain.functional.Either
import kz.porcuon.domain.functional.Failure
import kz.porcuon.domain.functional.Success
import kz.porcuon.domain.repositories.MovieRepository
import kz.porcuon.domain.use_cases.UseCase

class GetPopularMoviesUseCase(
    private val movieRepository: MovieRepository
) : UseCase<List<Movie>, Int>() {
    override suspend fun run(params: Int): Either<Throwable, List<Movie>> {
        return try {
            val response = movieRepository.getPopularMovies(params)
            Success(response)
        } catch (throwable: Throwable) {
            Failure(throwable)
        }
    }
}