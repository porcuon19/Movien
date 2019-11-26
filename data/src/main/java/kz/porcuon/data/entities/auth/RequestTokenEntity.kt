package kz.porcuon.data.entities.auth

import com.google.gson.annotations.SerializedName
import kz.porcuon.domain.data.auth.RequestToken
import java.io.Serializable

class RequestTokenEntity : Serializable {
    @SerializedName("success")
    var success: Boolean = false

    @SerializedName("expires_at")
    var expiresAt: String? = null

    @SerializedName("request_token")
    var requestToken: String? = null
}

fun RequestTokenEntity.toData(): RequestToken {
    val entity = this
    return RequestToken().apply {
        success = entity.success
        expiresAt = entity.expiresAt
        requestToken = entity.requestToken
    }
}