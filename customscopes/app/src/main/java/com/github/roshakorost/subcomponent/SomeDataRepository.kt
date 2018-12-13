package com.github.roshakorost.subcomponent

import com.github.roshakorost.subcomponent.di.AuthorizedScope
import com.github.roshakorost.subcomponent.di.Token
import javax.inject.Inject

/**
 * Some dependency that need's token for work.
 * As the result it can be created after login.
 */
@AuthorizedScope
class SomeDataRepository @Inject constructor(
    @Token private val token: String
) {

    fun loadSomeData(): String = "Some data.\nToken was $token."
}