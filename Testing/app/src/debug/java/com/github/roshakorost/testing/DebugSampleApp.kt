package com.github.roshakorost.testing

import android.app.Activity
import android.support.annotation.VisibleForTesting
import dagger.android.AndroidInjector


class DebugSampleApp : SampleApp() {

    @VisibleForTesting var customActivityInjector: AndroidInjector<Activity>? = null

    override fun activityInjector() = customActivityInjector ?: super.activityInjector()
}