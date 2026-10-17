package com.example

import com.example.data.CrimeCodeData
import com.example.data.EmsSopData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun verifyChaptersAndArticlesIntegrity() {
        // Must contain all 21 chapters (BAB I - XXI)
        assertEquals(21, CrimeCodeData.chapters.size)

        // Must have articles loaded
        assertTrue(CrimeCodeData.allArticles.size > 50)

        // Check specific key articles from the reference
        val article41 = CrimeCodeData.allArticles.find { it.id == "4.1" }
        assertNotNull("Pasal 4.1 harus ada", article41)
        assertEquals("Level 6", article41?.level)
        assertTrue(article41?.description?.contains("Perdagangan", ignoreCase = true) == true)
        assertNotNull("Pasal 4.1 harus memiliki catatan", article41?.note)

        val article23 = CrimeCodeData.allArticles.find { it.id == "2.3" }
        assertNotNull("Pasal 2.3 harus ada", article23)
        assertEquals("200% dari jumlah suap", article23?.fine)

        val article84 = CrimeCodeData.allArticles.find { it.id == "8.4" }
        assertNotNull("Pasal 8.4 harus ada", article84)
        assertEquals("R$ 5.000", article84?.fine)
    }

    @Test
    fun verifyStarTierGrouping() {
        assertEquals(7, CrimeCodeData.starTierDefinitions.size)

        val article14 = CrimeCodeData.allArticles.find { it.id == "1.4" } // Pembunuhan pejabat Level 6 - 7
        assertNotNull(article14)
        assertEquals(6, article14?.starRating)
        assertEquals("★★★★★★", article14?.starStars)

        val article11 = CrimeCodeData.allArticles.find { it.id == "1.1" } // Percobaan penyerangan Level 4
        assertNotNull(article11)
        assertEquals(4, article11?.starRating)
        assertEquals("★★★★", article11?.starStars)

        val article81 = CrimeCodeData.allArticles.find { it.id == "8.1" } // Menghina sipil Level 1
        assertNotNull(article81)
        assertEquals(1, article81?.starRating)
        assertEquals("★", article81?.starStars)

        val article151 = CrimeCodeData.allArticles.find { it.id == "15.1" } // Keterlibatan
        assertNotNull(article151)
        assertEquals(0, article151?.starRating)
    }

    @Test
    fun verifyEmsSopDataIntegrity() {
        // Personnel rule: 3 min, 4 max
        assertEquals(3, EmsSopData.MIN_PERSONNEL)
        assertEquals(4, EmsSopData.MAX_PERSONNEL)

        // 3 Restricted areas (Ruang Obat, Ruang Wadir, Ruang Ganti)
        assertEquals(3, EmsSopData.restrictedAreas.size)

        // 3 Warning steps (Isyarat 3x, VOIP 3x, Tindak)
        assertEquals(3, EmsSopData.warningSteps.size)

        // 7 Common EMS crimes (8.2, 11.1, 12.1, 13.1, 14.1, 14.2, 20.1)
        assertEquals(7, EmsSopData.commonCrimes.size)
        EmsSopData.commonCrimes.forEach { emsCrime ->
            val foundInKuhp = CrimeCodeData.allArticles.any { it.id == emsCrime.articleId }
            assertTrue("Pasal ${emsCrime.articleId} harus ada di KUHP", foundInKuhp)
        }

        // 5 Melamun steps
        assertEquals(5, EmsSopData.melamunSteps.size)

        // 26 UUP Roleplay rules from image 2
        assertEquals(26, EmsSopData.uupRules.size)
    }

    @Test
    fun verifySearchFiltering() {
        val query = "senjata"
        val matched = CrimeCodeData.allArticles.filter {
            it.description.contains(query, ignoreCase = true) ||
                    it.chapterTitle.contains(query, ignoreCase = true) ||
                    (it.note?.contains(query, ignoreCase = true) == true)
        }
        assertTrue("Pencarian 'senjata' harus menemukan hasil", matched.isNotEmpty())
    }

    @Test
    fun verifyLevelParsing() {
        val levels = listOf("Level 4", "Level 6 – 7", "Level 2")
        val maxLevel = levels.mapNotNull { lvl ->
            val digits = Regex("\\d+").findAll(lvl).map { it.value.toIntOrNull() ?: 0 }.toList()
            digits.maxOrNull()
        }.maxOrNull() ?: 0

        assertEquals(7, maxLevel)
    }
}
