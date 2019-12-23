package kz.porcuon.domain.use_cases.account

import kz.porcuon.domain.functional.Either
import kz.porcuon.domain.functional.Failure
import kz.porcuon.domain.functional.Success
import kz.porcuon.domain.repositories.AccountRepository
import kz.porcuon.domain.use_cases.UseCase

class SaveAccountDetailsUseCase(
    private val accountRepository: AccountRepository
) : UseCase<Unit, UseCase.None>() {
    override suspend fun run(params: None): Either<Throwable, Unit> {
        return try {
            val response = accountRepository.getAccountDetails()
            accountRepository.saveAccountId(response.id)
            accountRepository.saveAccountCache(response)
            Success(Unit)
        } catch (throwable: Throwable) {
            Failure(throwable)
        }
    }
}