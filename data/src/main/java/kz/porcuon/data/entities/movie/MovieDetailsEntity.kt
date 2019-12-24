package kz.porcuon.data.entities.movie

import com.google.gson.annotations.SerializedName
import kz.porcuon.data.configs.IMAGE_URL
import kz.porcuon.domain.data.movie.MovieDetails
import java.io.Serializable

class MovieDetailsEntity(
    @SerializedName("id") val id: Int
) : Serializable {
    @SerializedName("budget")
    var budget: Int? = null

    @SerializedName("genres")
    var genres: List<MovieGenreEntity>? = null

    @SerializedName("homepage")
    var homepage: String? = null

    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("poster_path")
    var posterPath: String? = null

    @SerializedName("release_date")
    var releaseDate: String? = null

    @SerializedName("revenue")
    var revenue: Int? = null

    @SerializedName("status")
    var status: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("vote_average")
    var voteAverage: Double? = null

    @SerializedName("vote_count")
    var voteCount: Int? = null

    @SerializedName("credits")
    var credits: MovieCreditsEntity? = null
}

fun MovieDetailsEntity.toData(): MovieDetails {
    val entity = this
    return MovieDetails(entity.id).apply {
        budget = entity.budget
        genres = entity.genres?.map(MovieGenreEntity::toData)
        homepage = entity.homepage
        overview = entity.overview
        posterPath = "$IMAGE_URL${entity.posterPath}"
        releaseDate = entity.releaseDate
        revenue = entity.revenue
        status = entity.status
        title = entity.title
        voteAverage = entity.voteAverage
        voteCount = entity.voteCount
        credits = entity.credits?.toData()
    }
}