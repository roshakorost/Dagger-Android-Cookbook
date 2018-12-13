package com.github.roshakorost.testing.di

import android.app.Application
import com.github.roshakorost.testing.SampleApp
import com.github.roshakorost.testing.main.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,

        MainModule::class
    ]
)
interface AppComponent {
    fun inject(app: SampleApp)

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): AppComponent.Builder
        @BindsInstance fun baseUrl(@BaseUrl baseUrl: String): AppComponent.Builder
        fun build(): AppComponent
    }
}