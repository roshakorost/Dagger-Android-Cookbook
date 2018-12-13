package com.github.roshakorost.subcomponent.di

import android.app.Activity
import com.github.roshakorost.subcomponent.main.MainModule
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.DispatchingAndroidInjector

@AuthorizedScope
@Subcomponent(modules = [MainModule::class])
interface AuthorizedComponent {

    fun activityInjector(): DispatchingAndroidInjector<Activity>

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun token(@Token token: String): AuthorizedComponent.Builder
        fun build(): AuthorizedComponent
    }
}