package com.github.roshakorost.sharedsubcomponent.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.roshakorost.sharedsubcomponent.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject


class MainActivityFragment : DaggerFragment() {

    @Inject lateinit var someDataManager: SomeDataManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.main_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        someDataManager.loadSomeData().observe(this, Observer { text_tv.text = it })
    }

}