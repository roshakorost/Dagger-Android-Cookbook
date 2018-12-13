package com.github.roshakorost.subcomponent.login

import android.content.Intent
import android.os.Bundle
import com.github.roshakorost.subcomponent.main.MainActivity
import com.github.roshakorost.subcomponent.R
import com.github.roshakorost.subcomponent.TokenStore
import com.github.roshakorost.subcomponent.sampleApp
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.login_activity.*
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

    @Inject lateinit var tokenStore: TokenStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        if (tokenStore.isAuthorized) {
            startHomeScreen()
            return
        }

        login.setOnClickListener {
            val userName = username.text.toString()
            val password = password.text.toString()

            tokenStore.token = "$userName:$password"
            sampleApp.enterAuthorizedScope()

            startHomeScreen()
        }
    }

    private fun startHomeScreen() {
        val intent = Intent(this, MainActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}
