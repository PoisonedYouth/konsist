package com.lemonappdev.konsist.core.provider

import com.lemonappdev.konsist.api.provider.KoImplementationProvider
import org.jetbrains.kotlin.psi.KtFunction

internal interface KoImplementationProviderCore : KoImplementationProvider, KoBaseProviderCore {
    val ktFunction: KtFunction

    override val hasImplementation: Boolean
        get() = ktFunction.hasBody()
}