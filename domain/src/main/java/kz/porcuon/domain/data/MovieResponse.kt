package kz.porcuon.domain.data

class MovieResponse {
    var page: Int? = null
    var totalPages: Int? = null
    var results: List<Movie>? = null

    class Movie {
        var popularity: Double? = null
        var voteCount: Int? = null
        var posterPath: String? = null
        var id: Int? = null
        var title: String? = null
        var voteAverage: Double? = null
        var overview: String? = null
        var releaseDate: String? = null
    }
}