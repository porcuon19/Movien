package kz.porcuon.data.di.internal

import android.app.Application
import kz.porcuon.data.sources.database.MovienDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

internal fun getModuleDatabase(application: Application): Module = module {
    single { MovienDatabase.getInstance(application) }
}