package com.github.roshakorost.sharedsubcomponent.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.github.roshakorost.sharedsubcomponent.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    companion object {
        var Intent.initialState: Int
            get() = getIntExtra("initialState", 0)
            set(value) {
                putExtra("initialState", value)
            }

        fun newIntent(context: Context, initialState: Int) = Intent(context, MainActivity::class.java)
            .apply { this.initialState = initialState }
    }

    @Inject lateinit var someDataManager: SomeDataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        refresh.setOnClickListener { someDataManager.refresh() }
    }

}
