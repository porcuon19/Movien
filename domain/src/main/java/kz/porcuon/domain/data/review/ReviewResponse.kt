package kz.porcuon.domain.data.review

class ReviewResponse(
    val id: Int
) {
    var page: Int? = null
    var totalResults: Int? = null
    var totalPages: Int? = null
    var results: List<Review>? = null

    class Review {
        var id: String? = null
        var author: String? = null
        var content: String? = null
        var url: String? = null
    }
}