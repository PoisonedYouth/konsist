package com.lemonappdev.konsist.api.architecture

import com.lemonappdev.konsist.api.container.koscope.KoScope

/**
 * Architecture creator.
 *
 * Creates a [ArchitectureScope] instance from the given dependencies.
 */
interface KoArchitectureCreator {
    /**
     * Defines an architecture using the specified dependencies.
     *
     * @param dependencies The function literal with receiver [KoArchitecture] that allows configuring the dependencies
     *                     of the architecture.
     * @return A [ArchitectureScope] containing the configured [KoArchitecture] instance and the associated [KoScope] object.
     */
    fun architecture(dependencies: KoArchitecture.() -> Unit): ArchitectureScope
}
