package kz.porcuon.domain.repositories

import kz.porcuon.domain.data.account.Account

interface AccountRepository {
    suspend fun getAccountDetails(): Account

    suspend fun getAccountDetailsCache(accountId: Int): Account

    suspend fun saveAccountCache(account: Account)

    suspend fun deleteAccountByIdCache(accountId: Int)

    fun saveAccountId(accountId: Int)

    fun deleteAccountId()
}