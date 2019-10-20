package kz.porcuon.data.entities

import com.google.gson.annotations.SerializedName
import kz.porcuon.data.configs.IMAGE_LOGO_URL
import kz.porcuon.data.configs.IMAGE_URL
import kz.porcuon.domain.data.MovieFullResponse
import java.io.Serializable

class MovieFullResponseEntity : Serializable {
    @SerializedName("adult")
    var adult: Boolean = false

    @SerializedName("backdrop_path")
    var backdropPath: String? = null

    @SerializedName("budget")
    var budget: Int? = null

    @SerializedName("genres")
    var genres: List<GenreEntity>? = null

    @SerializedName("homepage")
    var homepage: String? = null

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("imdb_id")
    var imdbId: String? = null

    @SerializedName("original_language")
    var originalLanguage: String? = null

    @SerializedName("original_title")
    var originalTitle: String? = null

    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("popularity")
    var popularity: Double? = null

    @SerializedName("poster_path")
    var posterPath: String? = null

    @SerializedName("production_companies")
    var productionCompanies: List<ProductionCompanyEntity>? = null

    @SerializedName("release_date")
    var releaseDate: String? = null

    @SerializedName("revenue")
    var revenue: Int? = null

    @SerializedName("status")
    var status: String? = null

    @SerializedName("tagline")
    var tagline: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("video")
    var video: Boolean? = false

    @SerializedName("vote_average")
    var voteAverage: Double? = null

    @SerializedName("vote_count")
    var voteCount: Int? = null

    class GenreEntity : Serializable {
        @SerializedName("id")
        var id: Int? = null

        @SerializedName("name")
        var name: String? = null
    }

    class ProductionCompanyEntity : Serializable {
        @SerializedName("id")
        var id: Int? = null

        @SerializedName("logo_path")
        var logoPath: String? = null

        @SerializedName("name")
        var name: String? = null

        @SerializedName("origin_country")
        var originCountry: String? = null
    }
}

fun MovieFullResponseEntity.toData(): MovieFullResponse {
    val entity = this
    return MovieFullResponse().apply {
        budget = entity.budget
        genres = entity.genres?.map {
            MovieFullResponse.Genre().apply {
                id = it.id
                name = it.name
            }
        }
        homepage = entity.homepage
        id = entity.id
        overview = entity.overview
        posterPath = "$IMAGE_URL${entity.posterPath}"
        productionCompanies = entity.productionCompanies?.map {
            MovieFullResponse.ProductionCompany().apply {
                id = it.id
                logoPath = "$IMAGE_LOGO_URL${it.logoPath}"
                name = it.name
                originCountry = it.originCountry
            }
        }
        releaseDate = entity.releaseDate
        revenue = entity.revenue
        status = entity.status
        title = entity.title
        voteAverage = entity.voteAverage
        voteCount = entity.voteCount
    }
}