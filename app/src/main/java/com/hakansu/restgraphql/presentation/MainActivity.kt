package com.hakansu.restgraphql.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hakansu.restgraphql.R
import com.hakansu.restgraphql.presentation.rest.JakeWhartonFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jakeWhartonFragment = JakeWhartonFragment.newInstance()
        putFragment(jakeWhartonFragment, jakeWhartonFragment.javaClass.simpleName, false)
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