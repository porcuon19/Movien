package kz.porcuon.data.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TPageableEntity<T> : Serializable {
    @SerializedName("page")
    var page: Int? = null

    @SerializedName("total_results")
    var totalResults: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    @SerializedName("results")
    var results: List<T> = ArrayList()
}