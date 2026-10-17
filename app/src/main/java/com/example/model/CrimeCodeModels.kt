package com.example.model

data class CrimeArticle(
    val id: String,
    val icon: String,
    val description: String,
    val level: String,
    val note: String? = null,
    val fine: String? = null,
    val chapterRoman: String,
    val chapterTitle: String,
    val chapterSubtitle: String
) {
    /**
     * Bintang rating (Maksimal Bintang 6, tidak ada Bintang 7)
     * Level 6 & Level 6 – 7 -> 6 Bintang
     * Level 5 -> 5 Bintang
     * Level 4 -> 4 Bintang
     * Level 3 -> 3 Bintang
     * Level 2 -> 2 Bintang
     * Level 1 -> 1 Bintang
     * Khusus (Keterlibatan) -> 0
     */
    val starRating: Int
        get() = when {
            level.contains("6") || level.contains("7") -> 6
            level.contains("5") -> 5
            level.contains("4") -> 4
            level.contains("3") -> 3
            level.contains("2") -> 2
            level.contains("1") -> 1
            else -> 0
        }

    val starStars: String
        get() = when (starRating) {
            6 -> "★★★★★★"
            5 -> "★★★★★"
            4 -> "★★★★"
            3 -> "★★★"
            2 -> "★★"
            1 -> "★"
            else -> "⚡"
        }

    val tierLabel: String
        get() = when (starRating) {
            6 -> if (level.contains("7")) "Bintang 6 (Level 6 – 7)" else "Bintang 6 (Level 6)"
            5 -> "Bintang 5 (Level 5)"
            4 -> "Bintang 4 (Level 4)"
            3 -> "Bintang 3 (Level 3)"
            2 -> "Bintang 2 (Level 2)"
            1 -> "Bintang 1 (Level 1)"
            else -> "Tingkat Khusus"
        }
}

data class CrimeChapter(
    val roman: String,
    val title: String,
    val subtitle: String,
    val articles: List<CrimeArticle>
)

data class StarTierGroup(
    val stars: Int,
    val title: String,
    val subtitle: String,
    val badgeColorHex: Long,
    val articles: List<CrimeArticle>
)
