package kz.porcuon.data.entities.movie

import com.google.gson.annotations.SerializedName
import kz.porcuon.data.configs.IMAGE_URL
import kz.porcuon.domain.data.movie.Movie
import java.io.Serializable

class MovieEntity(
    @SerializedName("id") val id: Int
) : Serializable {
    @SerializedName("popularity")
    var popularity: Double? = null

    @SerializedName("vote_count")
    var voteCount: Int? = null

    @SerializedName("poster_path")
    var posterPath: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("vote_average")
    var voteAverage: Double? = null

    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("release_date")
    var releaseDate: String? = null
}

fun MovieEntity.toData(): Movie {
    val entity = this
    return Movie(entity.id).apply {
        popularity = entity.popularity
        voteCount = entity.voteCount
        posterPath = "$IMAGE_URL${entity.posterPath}"
        title = entity.title
        voteAverage = entity.voteAverage
        overview = entity.overview
        releaseDate = entity.releaseDate
    }
}