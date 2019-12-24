package kz.porcuon.data.entities.movie

import com.google.gson.annotations.SerializedName
import kz.porcuon.domain.data.movie.MovieGenre
import java.io.Serializable

class MovieGenreEntity(
    @SerializedName("id") val id: Int
) : Serializable {
    @SerializedName("name") var name: String? = null
}

fun MovieGenreEntity.toData(): MovieGenre {
    val entity = this
    return MovieGenre(entity.id).apply {
        name = entity.name
    }
}