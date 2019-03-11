package com.hakansu.restgraphql.app

import android.app.Application
import com.hakansu.restgraphql.app.di.component.ApplicationComponent
import com.hakansu.restgraphql.app.di.component.DaggerApplicationComponent
import com.hakansu.restgraphql.app.di.module.ApplicationModule

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