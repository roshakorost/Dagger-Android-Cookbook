package com.github.roshakorost.sharedsubcomponent.di

import com.github.roshakorost.sharedsubcomponent.main.MainModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(modules = [MainModule::class, AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<SampleApp>