package com.github.roshakorost.sharedsubcomponent.splash

import android.content.Intent
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.github.roshakorost.sharedsubcomponent.main.MainActivity


class SplashActivity : AppCompatActivity() {

    private val handler = Handler()

    override fun onStart() {
        super.onStart()
        val action = Runnable {
            val intent = MainActivity.newIntent(this, (Math.random() * 10).toInt())
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }

        handler.postDelayed(action, 250L)
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacksAndMessages(null)
    }

}