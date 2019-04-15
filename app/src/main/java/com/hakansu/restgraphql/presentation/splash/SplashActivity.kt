package com.hakansu.restgraphql.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.hakansu.restgraphql.R
import com.hakansu.restgraphql.presentation.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.button)
    fun onClick(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}