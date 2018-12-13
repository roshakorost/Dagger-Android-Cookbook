package com.github.roshakorost.testing.main

import android.os.Bundle
import com.github.roshakorost.testing.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var repository: SomeComplexRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        content.text = repository.getOrLoadData()
    }
}
