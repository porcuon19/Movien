package kz.porcuon.data.sources.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kz.porcuon.data.configs.DB_NAME
import kz.porcuon.data.configs.DB_VERSION
import kz.porcuon.data.entities.account.AccountEntity
import kz.porcuon.data.sources.database.dao.AccountDao

@Database(entities = [AccountEntity::class], version = DB_VERSION)
abstract class MovienDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: MovienDatabase? = null

        fun getInstance(context: Context): MovienDatabase {
            if (INSTANCE == null) {
                synchronized(MovienDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, MovienDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }
    }

    abstract fun accountDao(): AccountDao
}