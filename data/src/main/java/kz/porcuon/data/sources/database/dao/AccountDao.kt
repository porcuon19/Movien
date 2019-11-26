package kz.porcuon.data.sources.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kz.porcuon.data.entities.account.AccountEntity

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAccount(accountEntity: AccountEntity)

    @Query("SELECT * FROM account WHERE id = :accountId")
    suspend fun getAccountById(accountId: Int): AccountEntity

    @Query("DELETE FROM account WHERE id = :accountId")
    suspend fun deleteAccountById(accountId: Int)
}