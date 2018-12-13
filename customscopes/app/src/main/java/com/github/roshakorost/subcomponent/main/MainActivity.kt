package com.github.roshakorost.subcomponent.main

import android.os.Bundle
import com.github.roshakorost.subcomponent.R
import com.github.roshakorost.subcomponent.SomeDataRepository
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var repository: SomeDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        content.text = repository.loadSomeData()
    }

}