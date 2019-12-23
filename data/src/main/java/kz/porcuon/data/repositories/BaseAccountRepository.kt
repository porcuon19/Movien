package kz.porcuon.data.repositories

import kz.porcuon.data.entities.account.toData
import kz.porcuon.data.entities.account.toEntity
import kz.porcuon.data.extensions.unwrap
import kz.porcuon.data.sources.database.MovienDatabase
import kz.porcuon.data.sources.network.AccountApi
import kz.porcuon.data.sources.preferences.clearAccountId
import kz.porcuon.data.sources.preferences.setAccountId
import kz.porcuon.domain.data.account.Account
import kz.porcuon.domain.repositories.AccountRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class BaseAccountRepository : AccountRepository, KoinComponent {
    private val database: MovienDatabase by inject()
    private val accountApi: AccountApi by inject()

    override suspend fun getAccountDetails(): Account {
        return accountApi.getAccountDetails().unwrap().toData()
    }

    override suspend fun getAccountDetailsCache(accountId: Int): Account {
        return database.accountDao().getAccountById(accountId).toData()
    }

    override suspend fun saveAccountCache(account: Account) {
        database.accountDao().saveAccount(account.toEntity())
    }

    override suspend fun deleteAccountByIdCache(accountId: Int) {
        database.accountDao().deleteAccountById(accountId)
    }

    override fun saveAccountId(accountId: Int) {
        setAccountId(accountId)
    }

    override fun deleteAccountId() {
        clearAccountId()
    }
}