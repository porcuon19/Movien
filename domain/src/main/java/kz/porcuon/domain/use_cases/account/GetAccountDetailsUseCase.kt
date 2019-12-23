package kz.porcuon.domain.use_cases.account

import kz.porcuon.domain.data.account.Account
import kz.porcuon.domain.functional.Either
import kz.porcuon.domain.functional.Failure
import kz.porcuon.domain.functional.Success
import kz.porcuon.domain.repositories.AccountRepository
import kz.porcuon.domain.use_cases.UseCase

class GetAccountDetailsUseCase(
    private val accountRepository: AccountRepository
) : UseCase<Account, Int>() {
    override suspend fun run(params: Int): Either<Throwable, Account> {
        /** [params] - accountId */
        return try {
            val response = accountRepository.getAccountDetailsCache(params)
            Success(response)
        } catch (throwable: Throwable) {
            Failure(throwable)
        }
    }
}