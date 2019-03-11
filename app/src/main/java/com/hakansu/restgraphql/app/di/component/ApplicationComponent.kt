package com.hakansu.restgraphql.app.di.component

import com.hakansu.restgraphql.app.di.module.ApplicationModule
import com.hakansu.restgraphql.app.di.module.NetworkModule
import com.hakansu.restgraphql.presentation.graphql.GraphqlFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun inject(graphqlFragment: GraphqlFragment)

}