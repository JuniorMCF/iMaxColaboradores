package com.imaxcolaboradores.app.app

import android.app.Application
import com.imaxcolaboradores.app.features.Login.di.loginModule
import com.imaxcolaboradores.app.features.Principal.di.solitudesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(getModules())
        }
    }

    private fun getModules() = arrayListOf(
        loginModule,
        solitudesModule
    )

}