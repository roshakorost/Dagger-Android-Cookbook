package com.github.roshakorost.subcomponent.login

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {
    @ContributesAndroidInjector internal abstract fun activityInjector(): LoginActivity
}