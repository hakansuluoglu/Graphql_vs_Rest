package com.hakansu.restgraphql

import android.app.Application
import com.hakansu.restgraphql.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .applicationModule(AppModule(this))
            .build()
    }
}