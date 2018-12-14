package com.github.roshakorost.sharedsubcomponent.main

import com.github.roshakorost.sharedsubcomponent.di.ActivityScope
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityFragmentInjectorModule::class, MainDataModule::class])
    internal abstract fun injector(): MainActivity

}

@Module
abstract class MainActivityFragmentInjectorModule {

    @ContributesAndroidInjector
    internal abstract fun injector(): MainActivityFragment

}

@Module
object MainDataModule {

    @JvmStatic
    @ActivityScope
    @Provides
    fun provideSomeDataManager(activity: MainActivity): SomeDataManager {
        val initialState = with(MainActivity) { activity.intent.initialState }
        return SomeDataManager(initialState)
    }

}