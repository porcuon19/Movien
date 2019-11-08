package kz.porcuon.movien

import android.app.Application
import kz.porcuon.data.initDataLayer

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDataLayer(this)
    }
}