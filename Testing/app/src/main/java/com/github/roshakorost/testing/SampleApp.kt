package com.github.roshakorost.testing

import android.app.Activity
import android.app.Application
import com.github.roshakorost.testing.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

open class SampleApp : Application(), HasActivityInjector {

    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .baseUrl("https://github.com/roshakorost/Dagger-Android-Cookbook/")
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
