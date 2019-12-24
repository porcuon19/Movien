package kz.porcuon.domain.data.movie

class MovieDetails(
    val id: Int
) {
    var budget: Int? = null
    var genres: List<MovieGenre>? = null
    var homepage: String? = null
    var overview: String? = null
    var posterPath: String? = null
    var releaseDate: String? = null
    var revenue: Int? = null
    var status: String? = null
    var title: String? = null
    var voteAverage: Double? = null
    var voteCount: Int? = null
    var credits: MovieCredits? = null
}