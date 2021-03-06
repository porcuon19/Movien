package kz.porcuon.data.entities.auth

import com.google.gson.annotations.SerializedName
import kz.porcuon.domain.data.auth.Session
import java.io.Serializable

class SessionEntity : Serializable {
    @SerializedName("success")
    var success: Boolean = false

    @SerializedName("session_id")
    var sessionId: String? = null
}

fun SessionEntity.toData(): Session {
    val entity = this
    return Session().apply {
        success = entity.success
        sessionId = entity.sessionId
    }
}