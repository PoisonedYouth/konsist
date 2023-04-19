package com.lemonappdev.konsist.core.declaration

import com.lemonappdev.konsist.core.cache.KoDeclarationCache
import org.jetbrains.kotlin.psi.KtObjectDeclaration

class KoObject(private val ktObjectDeclaration: KtObjectDeclaration) : KoComplexDeclaration(ktObjectDeclaration) {
    fun hasDataModifier() = ktObjectDeclaration.isData()

    companion object {
        private val cache = KoDeclarationCache<KoObject>()

        fun getInstance(ktObjectDeclaration: KtObjectDeclaration) =
            cache.getOrCreateInstance(ktObjectDeclaration) { KoObject(ktObjectDeclaration) }
    }
}