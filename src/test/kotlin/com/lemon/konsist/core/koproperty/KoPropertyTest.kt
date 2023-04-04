package com.lemon.konsist.core.koproperty

import com.lemon.konsist.TestSnippetProvider
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoPropertyTest {
    @Test
    fun `property-is-val`() {
        // given
        val sut = getSut("property-is-val")
            .properties()
            .first()

        // then
        with(sut) {
            isVal shouldBeEqualTo true
            isVar shouldBeEqualTo false
            isConst shouldBeEqualTo false
        }
    }

    @Test
    fun `property-is-var`() {
        // given
        val sut = getSut("property-is-var")
            .properties()
            .first()

        // then
        with(sut) {
            isVal shouldBeEqualTo false
            isVar shouldBeEqualTo true
            isConst shouldBeEqualTo false
        }
    }

    @Test
    fun `property-is-const`() {
        // given
        val sut = getSut("property-is-const")
            .properties(includeNested = true)
            .first()

        // then
        with(sut) {
            isVal shouldBeEqualTo true
            isVar shouldBeEqualTo false
            isConst shouldBeEqualTo true
        }
    }

    private fun getSut(fileName: String) = TestSnippetProvider.getSnippetKoScope("core/koproperty/snippet/$fileName.kttxt")
}