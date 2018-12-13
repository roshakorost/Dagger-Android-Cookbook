package com.github.roshakorost.subcomponent.di

import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthorizedScope