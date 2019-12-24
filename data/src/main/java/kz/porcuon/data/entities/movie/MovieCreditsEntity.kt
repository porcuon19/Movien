package kz.porcuon.data.entities.movie

import com.google.gson.annotations.SerializedName
import kz.porcuon.domain.data.movie.MovieCredits
import java.io.Serializable

class MovieCreditsEntity : Serializable {
    @SerializedName("cast")
    var cast: List<MovieCastEntity>? = null
}

fun MovieCreditsEntity.toData(): MovieCredits {
    val entity = this
    return MovieCredits().apply {
        cast = entity.cast?.map(MovieCastEntity::toData)
    }
}