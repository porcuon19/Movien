package kz.porcuon.data.entities.review

import com.google.gson.annotations.SerializedName
import kz.porcuon.domain.data.review.Review
import java.io.Serializable

class ReviewEntity : Serializable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("author")
    var author: String? = null

    @SerializedName("content")
    var content: String? = null

    @SerializedName("url")
    var url: String? = null
}

fun ReviewEntity.toData(): Review {
    val entity = this
    return Review().apply {
        id = entity.id
        author = entity.author
        content = entity.content
        url = entity.url
    }
}