package com.github.roshakorost.subcomponent

import android.app.Activity
import android.app.Application
import android.content.Context
import com.github.roshakorost.subcomponent.di.AuthorizedComponent
import com.github.roshakorost.subcomponent.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import java.lang.IllegalStateException
import javax.inject.Inject


open class SampleApp : Application(), HasActivityInjector {

    @Inject lateinit var tokenStore: TokenStore
    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    private val appComponent by lazy { DaggerAppComponent.builder().application(this).build() }
    private var authorizedComponent: AuthorizedComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        if (tokenStore.isAuthorized) enterAuthorizedScope()
    }

    fun enterAuthorizedScope() {
        val token = requireNotNull(tokenStore.token) { "enterAuthorizedScope should be called after token is set " }
        authorizedComponent = appComponent.authorizedComponent().token(token).build()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return AndroidInjector { activity ->
            val injected = authorizedComponent?.activityInjector()?.maybeInject(activity) ?: activityInjector.maybeInject(activity)
            if (!injected) throw IllegalStateException("AuthorizedComponent and appComponent cant find injector for ${activity::class.java}")
        }
    }

}

val Context.sampleApp: SampleApp
    get() = applicationContext as SampleApp