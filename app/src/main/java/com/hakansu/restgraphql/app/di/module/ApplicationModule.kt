package com.hakansu.restgraphql.app.di.module

import android.content.Context
import androidx.annotation.NonNull
import com.hakansu.restgraphql.app.App
import com.hakansu.restgraphql.data.DataRepository
import com.hakansu.restgraphql.domain.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: App) {

    @Singleton
    @Provides
    @NonNull
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun Repository(dataRepository: DataRepository): Repository {
        return dataRepository
    }

}