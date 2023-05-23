package com.lemonappdev.konsist.api.declaration

/**
 * Represents a Kotlin declaration.
 */
interface KoTypeDeclaration : KoNamedDeclaration {
    /**
     * The import alias name.
     */
    val importAliasName: String

    /**
     * The source type.
     */
    val sourceType: String

    /**
     * The fully qualified name of the type.
     */
    val fullyQualifiedName: String

    /**
     * Whatever type is nullable.
     */
    val isNullable: Boolean

    /**
     * Returns `true` if this type is import alias.
     */
    fun isImportAlias(): Boolean
}
