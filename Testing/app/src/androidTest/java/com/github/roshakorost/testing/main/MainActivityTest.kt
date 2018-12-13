package com.github.roshakorost.testing.main

import android.app.Activity
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.github.roshakorost.testing.di.BaseUrl
import com.github.roshakorost.testing.testutil.ReplaceInjectorRule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * We can run the test directly because of following reasons:
 *  1. Repository uses some persisted caches, that needs to be reset after each test
 *  2. We need to change the base url, so mock web sever can intercept connection
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule val replaceInjectorRule = ReplaceInjectorRule()
    @get:Rule val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Before
    fun before() {
        println("starting MockWebServer at http://localhost:8080/")
    }

    /**
     * We can replace our dependencies directly in the activity.
     * Dagger requires to have injected fields to be at least package private, we could use that in order to modify them.
     */
    @Test
    fun test_replace_dependency_directly() {

        replaceInjectorRule.activityInjector = AndroidInjector { activity ->
            //These method will be called when activity calls AndroidInjector.inject.
            //We create custom implementation that will change it
            if (activity is MainActivity) {
                activity.repository = SomeComplexRepository(
                    loader = RealDataLoader("http://localhost:8080/"),
                    store = InMemoryStore(null)
                )
            }
        }

        activityRule.launchActivity(null)
    }

    /**
     * Another option is to use dagger in order to generate needed dependencies.
     */
    @Test
    fun test_replace_dependency_using_dagger() {

        replaceInjectorRule.activityInjector = DaggerMainActivityTestingComponent.builder()
            .baseUrl("http://localhost:8080/")
            .store(InMemoryStore(null))
            .build()
            .injector()

        activityRule.launchActivity(null)
    }


}

private class InMemoryStore(override var someData: String?) : Store

@Component(modules = [DataLoaderModule::class, MainInjectorModule::class, AndroidSupportInjectionModule::class])
interface MainActivityTestingComponent {

    fun injector(): DispatchingAndroidInjector<Activity>

    @Component.Builder
    interface Builder {
        @BindsInstance fun baseUrl(@BaseUrl baseUrl: String): MainActivityTestingComponent.Builder
        @BindsInstance fun store(store: Store): MainActivityTestingComponent.Builder
        fun build(): MainActivityTestingComponent
    }
}