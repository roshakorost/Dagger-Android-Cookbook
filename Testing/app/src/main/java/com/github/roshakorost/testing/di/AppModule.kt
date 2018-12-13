package com.github.roshakorost.testing.di

import android.app.Application
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences =
        application.getSharedPreferences("app_sp", Application.MODE_PRIVATE)

}