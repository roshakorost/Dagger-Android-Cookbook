package com.github.roshakorost.testing.main

import android.content.SharedPreferences
import com.github.roshakorost.testing.di.BaseUrl
import javax.inject.Inject


class SomeComplexRepository @Inject constructor(
    private val loader: DataLoader,
    private val store: Store
) {

    fun getOrLoadData(): String = store.someData ?: loadAndCacheData()

    private fun loadAndCacheData(): String {
        val data = loader.loadSomeData()
        store.someData = data
        return data
    }

}


interface DataLoader {
    fun loadSomeData(): String
}

class RealDataLoader @Inject constructor(
    @BaseUrl private val baseUrl: String
) : DataLoader {

    override fun loadSomeData(): String = "Some data from $baseUrl"

}


interface Store {
    var someData: String?
}

class SharedPreferenceStore @Inject constructor(
    private val sp: SharedPreferences
) : Store {

    override var someData: String?
        get() = sp.getString("someData", null)
        set(value) {
            sp.edit().apply { putString("someData", value) }.apply()
        }

}
