package com.github.roshakorost.subcomponent.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @ContributesAndroidInjector internal abstract fun activityInjector(): MainActivity
}