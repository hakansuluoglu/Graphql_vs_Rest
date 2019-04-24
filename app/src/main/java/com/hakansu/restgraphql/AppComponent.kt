package com.hakansu.restgraphql

import com.hakansu.restgraphql.presentation.jakeWharton.JakeWhartonFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(jakeWhartonFragment: JakeWhartonFragment)

}