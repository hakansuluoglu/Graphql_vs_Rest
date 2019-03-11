package com.hakansu.restgraphql.app.di.component

import android.content.Context
import com.hakansu.restgraphql.app.App
import com.hakansu.restgraphql.app.di.module.ApplicationModule
import com.hakansu.restgraphql.app.di.module.NetworkModule
import com.hakansu.restgraphql.data.DataFactory
import com.hakansu.restgraphql.data.api.GraphqlClient
import com.hakansu.restgraphql.data.api.RestClient
import com.hakansu.restgraphql.domain.Repository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun inject(app: App)

    fun repository(): Repository

    fun context(): Context

    fun dataFactory(): DataFactory

    fun restClient(): RestClient

    fun graphlClient(): GraphqlClient


}