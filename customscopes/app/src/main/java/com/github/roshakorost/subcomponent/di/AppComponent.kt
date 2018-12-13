package com.github.roshakorost.subcomponent.di

import android.app.Application
import com.github.roshakorost.subcomponent.login.LoginModule
import com.github.roshakorost.subcomponent.SampleApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,

        LoginModule::class
    ]
)
interface AppComponent {

    fun inject(app: SampleApp)
    fun authorizedComponent(): AuthorizedComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): AppComponent.Builder
        fun build(): AppComponent
    }
}