package com.github.roshakorost.testing.testutil

import android.app.Activity
import android.support.test.InstrumentationRegistry
import com.github.roshakorost.testing.DebugSampleApp
import dagger.android.AndroidInjector
import org.junit.rules.TestWatcher
import org.junit.runner.Description


class ReplaceInjectorRule(
    var activityInjector: AndroidInjector<Activity>? = null
) : TestWatcher() {

    @Suppress("UNCHECKED_CAST")
    override fun starting(description: Description) {
        app.customActivityInjector = activityInjector
    }

    override fun finished(description: Description) {
        app.customActivityInjector = null
    }

    private val app
        get() = InstrumentationRegistry.getTargetContext().applicationContext as DebugSampleApp
}