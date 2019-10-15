package kz.porcuon.domain

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): MovieResponse
}