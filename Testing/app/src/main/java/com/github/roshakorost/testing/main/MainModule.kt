package com.github.roshakorost.testing.main

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [DataLoaderModule::class, StoreModule::class])
abstract class MainModule {
    @ContributesAndroidInjector internal abstract fun contributeActivityInjector(): MainActivity
}

@Module
abstract class DataLoaderModule {
    @Binds internal abstract fun dataLoader(realDataLoader: RealDataLoader): DataLoader
}

@Module
abstract class StoreModule {
    @Binds internal abstract fun store(sharedPreferenceStore: SharedPreferenceStore): Store
}