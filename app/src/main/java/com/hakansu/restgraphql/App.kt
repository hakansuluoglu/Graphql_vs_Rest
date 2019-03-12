package com.hakansu.restgraphql

import android.app.Application
import com.hakansu.restgraphql.di.DaggerApplicationComponent

class App : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}