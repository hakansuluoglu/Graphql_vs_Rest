package com.hakansu.restgraphql.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hakansu.restgraphql.presentation.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import com.hakansu.restgraphql.R


class SplashActivity : AppCompatActivity() {

    var clickCount = 0
    var timer:TimerTask ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val initialText = "Merhaba arkadaşlar uygulamama hoşgeldiniz.. " +
                "\nBirazdan aşağıda bir buton belierecek. " +
                "\nBöyle bir ekran olmazsa olmaz biliyorsunuz " +
                "\nneyse tıkla hadi..."
        textView.text = ""
        addtext(initialText)
        button.setOnClickListener { onClick() }
    }

    fun addtext(naber:String) {
        val size = naber.length
        var count = 0

        timer =  Timer().scheduleAtFixedRate(0, 40) {
            runOnUiThread {
                if (count < size) {
                    textView?.text = textView?.text.toString().plus(naber[count])
                    count++
                } else {
                    button.animate()
                        .translationY(0f)
                        .alpha(1.0f)
                        .setDuration(10000)
                        .setListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationStart(animation: Animator?) {
                                super.onAnimationStart(animation)
                                button.visibility = View.VISIBLE
                                timer?.cancel()
                                timer = null
                            }
                        })
                }
            }
        }
    }

    fun onClick() {
        clickCount++
        if (clickCount == 1) {
            button.visibility = View.GONE
            addtext(
                "\n\n......" +
                        "\nBu tıklamayı beğenmedim........... " +
                        "\nBen bas dediğimde arka arkaya 4 kere tıkla." +
                        "\nhızlı ol..." +
                        "\nHADİ BAŞLA!"
            )
        }
        if (clickCount == 5) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}

