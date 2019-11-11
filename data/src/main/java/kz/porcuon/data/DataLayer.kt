package kz.porcuon.data

import android.app.Application
import com.orhanobut.hawk.Hawk

fun initDataLayer(application: Application) {
    Hawk.init(application).build()
}