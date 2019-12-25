package kz.porcuon.domain.data.movie

class Movie(
    val id: Int
) {
    var popularity: Double? = null
    var voteCount: Int? = null
    var posterPath: String? = null
    var title: String? = null
    var voteAverage: Double? = null
    var overview: String? = null
    var releaseDate: String? = null
}