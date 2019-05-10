package com.hakansu.restgraphql

import com.hakansu.restgraphql.presentation.searchUserFragment.SearchUserFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(searchUserFragment: SearchUserFragment)

}