package kz.porcuon.domain.data

class MovieFullResponse {
    var budget: Int? = null
    var genres: List<Genre>? = null
    var homepage: String? = null
    var id: Int? = null
    var overview: String? = null
    var posterPath: String? = null
    var productionCompanies: List<ProductionCompany>? = null
    var releaseDate: String? = null
    var revenue: Int? = null
    var status: String? = null
    var title: String? = null
    var voteAverage: Double? = null
    var voteCount: Int? = null

    class Genre {
        var id: Int? = null
        var name: String? = null
    }
    class ProductionCompany {
        var id: Int? = null
        var logoPath: String? = null
        var name: String? = null
        var originCountry: String? = null
    }
}