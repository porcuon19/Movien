package kz.porcuon.movien

import android.app.Application
import kz.porcuon.data.di.external.getModuleRepository
import kz.porcuon.data.initDataLayer
import kz.porcuon.movien.di.getModuleUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    getModuleRepository(),
                    getModuleUseCase()
                )
            )
        }

        initDataLayer(this)
    }
}