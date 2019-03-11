package com.hakansu.restgraphql.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apollographql.apollo.ApolloCall
import com.hakansu.restgraphql.R

class MainActivity : AppCompatActivity() {

   // lateinit var githuntFeedCall: ApolloCall<GitRepos.Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}