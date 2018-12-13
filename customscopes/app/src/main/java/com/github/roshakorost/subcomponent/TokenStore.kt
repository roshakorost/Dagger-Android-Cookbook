package com.github.roshakorost.subcomponent

import android.content.SharedPreferences
import com.github.roshakorost.subcomponent.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class TokenStore @Inject constructor(
    private val sp: SharedPreferences
) {

    val isAuthorized
        get() = token != null

    var token: String?
        get() = sp.getString("token", null)
        set(value) {
            sp.edit().apply { putString("token", value) }.apply()
        }
}