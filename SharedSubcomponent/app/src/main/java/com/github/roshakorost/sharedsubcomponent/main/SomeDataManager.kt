package com.github.roshakorost.sharedsubcomponent.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations


class SomeDataManager(initialValue: Int) {
    private val someData = MutableLiveData<Int>().apply { value = initialValue }

    fun loadSomeData(): LiveData<String> = Transformations.map(someData) { "Current state $it" }

    fun refresh() {
        someData.value = someData.value!!.inc()
    }
}