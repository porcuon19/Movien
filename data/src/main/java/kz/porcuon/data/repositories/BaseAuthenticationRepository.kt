package kz.porcuon.data.repositories

import kz.porcuon.data.entities.auth.toData
import kz.porcuon.data.extensions.unwrap
import kz.porcuon.data.sources.network.AuthenticationApi
import kz.porcuon.data.sources.preferences.setSessionId
import kz.porcuon.domain.data.auth.RequestToken
import kz.porcuon.domain.data.auth.Session
import kz.porcuon.domain.repositories.AuthenticationRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class BaseAuthenticationRepository : AuthenticationRepository, KoinComponent {

    private val authenticationApi: AuthenticationApi by inject()

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