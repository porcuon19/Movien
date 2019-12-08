package kz.porcuon.data.entities.review

import com.google.gson.annotations.SerializedName
import kz.porcuon.domain.data.review.ReviewResponse
import java.io.Serializable

class ReviewResponseEntity(
    @SerializedName("id") val id: Int
) : Serializable {

    @SerializedName("page")
    var page: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    @SerializedName("total_results")
    var totalResults: Int? = null

    @SerializedName("results")
    var results: List<ReviewEntity>? = null

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
}

fun ReviewResponseEntity.toData(): ReviewResponse {
    val entity = this
    return ReviewResponse(id).apply {
        page = entity.page
        totalPages = entity.totalPages
        totalResults = entity.totalResults
        results = entity.results?.map {
            ReviewResponse.Review().apply {
                id = it.id
                author = it.author
                content = it.content
                url = it.url
            }
        }
    }
}