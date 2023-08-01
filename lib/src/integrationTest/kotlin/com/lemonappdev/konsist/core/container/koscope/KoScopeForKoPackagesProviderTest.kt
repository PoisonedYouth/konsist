package com.lemonappdev.konsist.core.container.koscope

import com.lemonappdev.konsist.TestSnippetProvider
import org.amshove.kluent.assertSoftly
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoScopeForKoPackagesProviderTest {

    @Test
    fun `scope-has-no-package`() {
        // given
        val sut = getSnippetFile("scope-has-no-package")

        // then
        assertSoftly(sut) {
            packages.toList() shouldBeEqualTo emptyList()
            hasPackages() shouldBeEqualTo false
        }
    }

    @Test
    fun `scope-has-package`() {
        // given
        val sut = getSnippetFile("scope-has-package")

        // then
        assertSoftly(sut) {
            packages.map { it.name }.toList() shouldBeEqualTo listOf("samplepackage")
            hasPackages() shouldBeEqualTo true
            hasPackages("com.samplepackage") shouldBeEqualTo true
            hasPackages("samplepackage") shouldBeEqualTo true
            hasPackages("com.otherpackage") shouldBeEqualTo false
            hasPackages("otherpackage") shouldBeEqualTo false
        }
    }

    private fun getSnippetFile(fileName: String) =
        TestSnippetProvider.getSnippetKoScope("core/container/koscope/snippet/forkopackagesprovider/", fileName)
}