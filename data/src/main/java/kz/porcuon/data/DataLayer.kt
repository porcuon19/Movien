package kz.porcuon.data

import android.app.Application
import com.orhanobut.hawk.Hawk
import kz.porcuon.data.di.internal.getModuleApi
import kz.porcuon.data.di.internal.getModuleDatabase
import kz.porcuon.data.di.internal.getModuleNetwork
import org.koin.core.context.loadKoinModules

fun initDataLayer(application: Application) {
    Hawk.init(application).build()
    loadKoinModules(
        listOf(
            getModuleDatabase(application),
            getModuleNetwork(),
            getModuleApi()
        )
    )
}