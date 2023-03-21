package com.lemon.konsist

import com.lemon.konsist.core.declaration.KoScope
import java.io.File

object TestSnippetProvider {
    private val projectPath = File("").absoluteFile.path
    private val testSourceSetPath = "$projectPath/src/test/kotlin/com/lemon/konsist"

    fun getSnippetKoScope(snippetRelativePath: String): KoScope {
        val snippetPath = "$testSourceSetPath/$snippetRelativePath"
        return KoFileImporter.importFile(snippetPath)
    }
}
