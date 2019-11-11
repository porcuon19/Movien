package kz.porcuon.data

import kz.porcuon.data.di.ServiceLocator
import kz.porcuon.data.entities.toData
import kz.porcuon.data.extensions.unwrap
import kz.porcuon.domain.data.RequestToken
import kz.porcuon.domain.data.Session
import kz.porcuon.domain.repositories.AuthenticationRepository

class AuthenticationSource : AuthenticationRepository {

    private val authenticationApi = ServiceLocator.authenticationApi

    override suspend fun getRequestToken(): RequestToken {
        return authenticationApi.getRequestToken().unwrap().toData()
    }

    override suspend fun validateRequestToken(username: String, password: String, requestToken: String): RequestToken {
        return authenticationApi.validateRequestToken(username, password, requestToken).unwrap().toData()
    }

    override suspend fun createSession(requestToken: String): Session {
        return authenticationApi.createSession(requestToken).unwrap().toData()
    }

    override fun saveSessionId(sessionId: String) {
        setSessionId(sessionId)
    }
}