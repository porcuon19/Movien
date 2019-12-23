package kz.porcuon.domain.use_cases.auth

import kz.porcuon.domain.functional.Either
import kz.porcuon.domain.functional.Failure
import kz.porcuon.domain.functional.Success
import kz.porcuon.domain.repositories.AccountRepository
import kz.porcuon.domain.repositories.AuthenticationRepository
import kz.porcuon.domain.use_cases.UseCase

class LogoutUseCase(
    private val authenticationRepository: AuthenticationRepository,
    private val accountRepository: AccountRepository
) : UseCase<Unit, UseCase.None>() {
    override suspend fun run(params: None): Either<Throwable, Unit> {
        return try {
            accountRepository.deleteAccountId()
            authenticationRepository.deleteSessionId()
            Success(Unit)
        } catch (throwable: Throwable) {
            Failure(throwable)
        }
    }
}