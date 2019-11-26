package kz.porcuon.domain.repositories

import kz.porcuon.domain.data.account.Account

interface AccountRepository {
    suspend fun getAccountById(): Account

    suspend fun getAccountByIdCache(accountId: Int): Account

    suspend fun saveAccountCache(account: Account)

    suspend fun deleteAccountByIdCache(accountId: Int)

    fun saveAccountId(accountId: Int)
}