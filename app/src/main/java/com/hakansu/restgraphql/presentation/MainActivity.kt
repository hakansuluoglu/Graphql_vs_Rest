package com.hakansu.restgraphql.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hakansu.restgraphql.R
import com.hakansu.restgraphql.presentation.graphql.GraphqlFragment
import com.hakansu.restgraphql.presentation.rest.RestFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val graphqlFragment = GraphqlFragment.newInstance()
        val restFragment = RestFragment.newInstance()
        //putFragment(graphqlFragment, graphqlFragment.javaClass.simpleName, false)
        putFragment(restFragment, restFragment.javaClass.simpleName, false)
    }


    fun putFragment(fragment: Fragment, tagName: String, addToStack: Boolean) {
        if (addToStack) {
            supportFragmentManager.beginTransaction().replace(R.id.frame_content, fragment, tagName)
                .addToBackStack(tagName).commitAllowingStateLoss()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.frame_content, fragment, tagName)
                .commitAllowingStateLoss()
        }
    }
}