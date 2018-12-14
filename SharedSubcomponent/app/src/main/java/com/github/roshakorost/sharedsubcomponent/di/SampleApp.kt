package com.github.roshakorost.sharedsubcomponent.di

import dagger.android.support.DaggerApplication


class SampleApp : DaggerApplication() {

    override fun applicationInjector(): AppComponent = DaggerAppComponent.create()
}