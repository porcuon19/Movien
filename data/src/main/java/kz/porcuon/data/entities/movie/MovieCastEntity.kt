package kz.porcuon.data.entities.movie

import com.google.gson.annotations.SerializedName
import kz.porcuon.domain.data.movie.MovieCast
import java.io.Serializable

class MovieCastEntity(
    val id: Int
) : Serializable {
    @SerializedName("character")
    var character: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("profile_path")
    var profilePath: String? = null
}

fun MovieCastEntity.toData(): MovieCast {
    val entity = this
    return MovieCast(entity.id).apply {
        character = entity.character
        name = entity.name
        profilePath = entity.profilePath
    }
}