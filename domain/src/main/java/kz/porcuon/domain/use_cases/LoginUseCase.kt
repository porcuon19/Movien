package kz.porcuon.domain.use_cases

import kz.porcuon.domain.functional.Either
import kz.porcuon.domain.functional.Failure
import kz.porcuon.domain.functional.Success
import kz.porcuon.domain.repositories.AuthenticationRepository
import kz.porcuon.domain.use_cases.request_params.LoginParams

class LoginUseCase(
    private val authenticationRepository: AuthenticationRepository
) : UseCase<Unit, LoginParams>() {
    override suspend fun run(params: LoginParams): Either<Throwable, Unit> {
        return try {
            authenticationRepository.apply {
                val requestToken = getRequestToken()
                validateRequestToken(params.username, params.password, requestToken.requestToken!!)
                val session = createSession(requestToken.requestToken!!)
                saveSessionId(session.sessionId!!)
            }
            Success(Unit)
        } catch (throwable: Throwable) {
            Failure(throwable)
        }
    }
}