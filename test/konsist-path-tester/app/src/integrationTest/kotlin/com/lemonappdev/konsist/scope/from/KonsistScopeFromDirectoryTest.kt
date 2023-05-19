package com.lemonappdev.konsist.scope.from

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.helper.ext.mapToFilePaths
import com.lemonappdev.konsist.helper.util.PathProvider.appMainSourceSetDirectory
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldThrow
import org.amshove.kluent.withMessage
import org.junit.jupiter.api.Test

class KonsistScopeFromDirectoryTest {
    @Test
    fun `scopeFromDirectory`() {
        // given
        val sut = Konsist
            .scopeFromDirectory("$appMainSourceSetDirectory/sample/")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$appMainSourceSetDirectory/sample/AppClass.kt",
                "$appMainSourceSetDirectory/sample/data/AppDataClass.kt",
            ),
        )
    }

    @Test
    fun `scopeFromDirectory throws exception if path does not exist`() {
        // given
        val func = { Konsist.scopeFromDirectory("$appMainSourceSetDirectory/nonExisting/") }

        // then
        val message = "Directory does not exist: $appMainSourceSetDirectory/nonExisting/"
        func shouldThrow IllegalArgumentException::class withMessage message
    }

    @Test
    fun `scopeFromDirectory throws exception if path points to file`() {
        // given
        val func = { Konsist.scopeFromDirectory("$appMainSourceSetDirectory/sample/AppClass.kt") }

        // then
        val message = "Path is a file, but should be a directory: $appMainSourceSetDirectory/sample/AppClass.kt"
        func shouldThrow IllegalArgumentException::class withMessage message
    }
}