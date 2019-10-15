package kz.porcuon.data.entities

import com.google.gson.annotations.SerializedName
import kz.porcuon.data.configs.IMAGE_URL
import kz.porcuon.domain.data.MovieResponse
import java.io.Serializable

class MovieResponseEntity : Serializable {
    @SerializedName("page")
    var page: Int? = null

    @SerializedName("total_results")
    var totalResults: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    @SerializedName("results")
    var results: List<MovieEntity>? = null

    class MovieEntity : Serializable {
        @SerializedName("popularity")
        var popularity: Double? = null

        @SerializedName("vote_count")
        var voteCount: Int? = null

        @SerializedName("video")
        var video: Boolean = false

        @SerializedName("poster_path")
        var posterPath: String? = null

        @SerializedName("id")
        var id: Int? = null

        @SerializedName("adult")
        var adult: Boolean = false

        @SerializedName("backdrop_path")
        var backdropPath: String? = null

        @SerializedName("original_language")
        var originalLanguage: String? = null

        @SerializedName("genre_ids")
        var genreIds: List<Int>? = null

        @SerializedName("title")
        var title: String? = null

        @SerializedName("vote_average")
        var voteAverage: Double? = null

        @SerializedName("overview")
        var overview: String? = null

        @SerializedName("release_date")
        var releaseDate: String? = null
    }
}

fun MovieResponseEntity.toData(): MovieResponse {
    val entity = this
    return MovieResponse().apply {
        page = entity.page
        totalPages = entity.totalPages
        results = entity.results?.map {
            MovieResponse.Movie().apply {
                popularity = it.popularity
                voteCount = it.voteCount
                posterPath = "$IMAGE_URL${it.posterPath}"
                id = it.id
                title = it.title
                voteAverage = it.voteAverage
                overview = it.overview
                releaseDate = it.releaseDate
            }
        }
    }
}