package kz.porcuon.domain.repositories

import kz.porcuon.domain.data.RequestToken
import kz.porcuon.domain.data.Session

interface AuthenticationRepository {
    suspend fun getRequestToken(): RequestToken

    suspend fun validateRequestToken(username: String, password: String, requestToken: String): RequestToken

    suspend fun createSession(requestToken: String): Session

    fun saveSessionId(sessionId: String)
}