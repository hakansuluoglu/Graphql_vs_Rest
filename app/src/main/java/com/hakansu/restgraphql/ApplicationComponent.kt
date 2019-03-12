package com.hakansu.restgraphql

import com.hakansu.restgraphql.presentation.graphql.GraphqlFragment
import com.hakansu.restgraphql.presentation.rest.RestFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(graphqlFragment: GraphqlFragment)
    fun inject(restFragment: RestFragment)

}