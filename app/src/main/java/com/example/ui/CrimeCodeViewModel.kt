package com.example.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.CrimeCodeData
import com.example.model.CrimeArticle
import com.example.model.CrimeChapter
import com.example.model.StarTierGroup
import com.example.model.UupRule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

enum class AppMainTab {
    DASHBOARD,      // Halaman Dasbor
    KODE_KRIMINAL,  // Panel 1: Kode Kriminal
    SOP_EMS,        // Panel 2: SOP Penjagaan EMS
    UUD_ROLEPLAY    // Panel 3: UUD Roleplay Kota 5
}

enum class CrimeNavTab {
    ALL_CHAPTERS,   // Tab 21 Bab
    BY_STARS,       // Tab Tingkat Bintang (1 - 6)
    FAVORITES       // Tab Panel Favorit
}

enum class FilterAttribute(val label: String) {
    ALL("Semua Kategori"),
    WITH_FINE("💰 Memiliki Denda"),
    WITH_NOTE("📌 Memiliki Catatan")
}

data class CrimeUiState(
    val appMainTab: AppMainTab = AppMainTab.DASHBOARD,
    val activeNavTab: CrimeNavTab = CrimeNavTab.ALL_CHAPTERS,
    val searchQuery: String = "",
    val selectedStarFilter: Int? = null, // null = Semua Bintang, 1..6, 0 = Khusus
    val selectedAttributeFilter: FilterAttribute = FilterAttribute.ALL,
    val favoriteArticleIds: Set<String> = emptySet(),
    val expandedChapters: Set<String> = CrimeCodeData.chapters.map { it.roman }.toSet(),
    val expandedStarTiers: Set<Int> = CrimeCodeData.starTierDefinitions.map { it.starRating }.toSet(),
    val activeArticleDetail: CrimeArticle? = null,
    val activeUupDetail: UupRule? = null,
    val filteredChapters: List<CrimeChapter> = CrimeCodeData.chapters,
    val filteredStarGroups: List<StarTierGroup> = emptyList(),
    val favoriteArticles: List<CrimeArticle> = emptyList(),
    val searchResults: List<CrimeArticle> = emptyList()
)

class CrimeCodeViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences("crime_code_prefs", Context.MODE_PRIVATE)

    private val _appMainTab = MutableStateFlow(AppMainTab.DASHBOARD)
    private val _activeNavTab = MutableStateFlow(CrimeNavTab.ALL_CHAPTERS)
    private val _searchQuery = MutableStateFlow("")
    private val _selectedStarFilter = MutableStateFlow<Int?>(null)
    private val _selectedAttributeFilter = MutableStateFlow(FilterAttribute.ALL)
    private val _favoriteArticleIds = MutableStateFlow<Set<String>>(loadFavorites())
    private val _expandedChapters = MutableStateFlow<Set<String>>(
        CrimeCodeData.chapters.map { it.roman }.toSet()
    )
    private val _expandedStarTiers = MutableStateFlow<Set<Int>>(
        CrimeCodeData.starTierDefinitions.map { it.starRating }.toSet()
    )
    private val _activeArticleDetail = MutableStateFlow<CrimeArticle?>(null)
    private val _activeUupDetail = MutableStateFlow<UupRule?>(null)

    val uiState: StateFlow<CrimeUiState> = combine(
        combine(_appMainTab, _activeNavTab, _searchQuery, _selectedStarFilter, _selectedAttributeFilter) { a, b, c, d, e ->
            Tuple5(a, b, c, d, e)
        },
        combine(_favoriteArticleIds, _expandedChapters, _expandedStarTiers, _activeArticleDetail) { a, b, c, d ->
            Tuple4(a, b, c, d)
        },
        _activeUupDetail
    ) { (mainTab, crimeTab, query, starFilter, attrFilter), (favorites, expandedCh, expandedStars, activeDetail), activeUup ->

        val trimmedQuery = query.trim().lowercase()

        fun matchesFilter(article: CrimeArticle): Boolean {
            val matchesQuery = if (trimmedQuery.isEmpty()) true else {
                article.id.lowercase().contains(trimmedQuery) ||
                        article.description.lowercase().contains(trimmedQuery) ||
                        article.chapterTitle.lowercase().contains(trimmedQuery) ||
                        article.level.lowercase().contains(trimmedQuery) ||
                        (article.note?.lowercase()?.contains(trimmedQuery) == true) ||
                        (article.fine?.lowercase()?.contains(trimmedQuery) == true)
            }

            val matchesStar = if (starFilter == null) true else {
                article.starRating == starFilter
            }

            val matchesAttr = when (attrFilter) {
                FilterAttribute.ALL -> true
                FilterAttribute.WITH_FINE -> !article.fine.isNullOrBlank()
                FilterAttribute.WITH_NOTE -> !article.note.isNullOrBlank()
            }

            return matchesQuery && matchesStar && matchesAttr
        }

        // Suggestions search preview
        val searchResults = if (trimmedQuery.isNotEmpty()) {
            CrimeCodeData.allArticles.filter { matchesFilter(it) }.take(8)
        } else {
            emptyList()
        }

        // Filtered chapters for Bab Tab
        val filteredChapters = CrimeCodeData.chapters.mapNotNull { chapter ->
            val matching = chapter.articles.filter { matchesFilter(it) }
            if (matching.isNotEmpty()) {
                chapter.copy(articles = matching)
            } else null
        }

        // Filtered star tier groups for Bintang Tab (Max 6 stars, no star 7)
        val filteredStarGroups = CrimeCodeData.starTierDefinitions.mapNotNull { def ->
            val matching = CrimeCodeData.allArticles.filter { art ->
                art.starRating == def.starRating && matchesFilter(art)
            }
            if (matching.isNotEmpty()) {
                StarTierGroup(
                    stars = def.starRating,
                    title = def.title,
                    subtitle = def.subtitle,
                    badgeColorHex = def.colorHex,
                    articles = matching
                )
            } else null
        }

        // Articles in Favorit Tab
        val favoriteArticles = CrimeCodeData.allArticles.filter { art ->
            favorites.contains(art.id) && matchesFilter(art)
        }

        CrimeUiState(
            appMainTab = mainTab,
            activeNavTab = crimeTab,
            searchQuery = query,
            selectedStarFilter = starFilter,
            selectedAttributeFilter = attrFilter,
            favoriteArticleIds = favorites,
            expandedChapters = expandedCh,
            expandedStarTiers = expandedStars,
            activeArticleDetail = activeDetail,
            activeUupDetail = activeUup,
            filteredChapters = filteredChapters,
            filteredStarGroups = filteredStarGroups,
            favoriteArticles = favoriteArticles,
            searchResults = searchResults
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = CrimeUiState()
    )

    private fun loadFavorites(): Set<String> {
        return prefs.getStringSet("favorite_articles", emptySet()) ?: emptySet()
    }

    private fun persistFavorites(set: Set<String>) {
        prefs.edit().putStringSet("favorite_articles", set).apply()
    }

    fun setAppMainTab(tab: AppMainTab) {
        _appMainTab.value = tab
    }

    fun setCrimeNavTab(tab: CrimeNavTab) {
        _activeNavTab.value = tab
    }

    fun onSearchQueryChanged(newQuery: String) {
        _searchQuery.value = newQuery

        val trimmed = newQuery.trim().lowercase()
        val exactMatch = CrimeCodeData.allArticles.firstOrNull { it.id.lowercase() == trimmed }
        if (exactMatch != null) {
            _activeArticleDetail.value = exactMatch
        }
    }

    fun clearSearch() {
        _searchQuery.value = ""
    }

    fun setStarFilter(star: Int?) {
        _selectedStarFilter.value = star
    }

    fun setAttributeFilter(attr: FilterAttribute) {
        _selectedAttributeFilter.value = attr
    }

    fun resetFilters() {
        _selectedStarFilter.value = null
        _selectedAttributeFilter.value = FilterAttribute.ALL
        _searchQuery.value = ""
    }

    fun toggleFavorite(articleId: String) {
        val current = _favoriteArticleIds.value.toMutableSet()
        if (current.contains(articleId)) {
            current.remove(articleId)
        } else {
            current.add(articleId)
        }
        _favoriteArticleIds.value = current
        persistFavorites(current)
    }

    fun toggleChapterExpansion(roman: String) {
        val current = _expandedChapters.value.toMutableSet()
        if (current.contains(roman)) {
            current.remove(roman)
        } else {
            current.add(roman)
        }
        _expandedChapters.value = current
    }

    fun toggleStarTierExpansion(starRating: Int) {
        val current = _expandedStarTiers.value.toMutableSet()
        if (current.contains(starRating)) {
            current.remove(starRating)
        } else {
            current.add(starRating)
        }
        _expandedStarTiers.value = current
    }

    fun expandAll() {
        _expandedChapters.value = CrimeCodeData.chapters.map { it.roman }.toSet()
        _expandedStarTiers.value = CrimeCodeData.starTierDefinitions.map { it.starRating }.toSet()
    }

    fun collapseAll() {
        _expandedChapters.value = emptySet()
        _expandedStarTiers.value = emptySet()
    }

    fun openArticleDetail(article: CrimeArticle) {
        _activeArticleDetail.value = article
    }

    fun openArticleById(articleId: String) {
        val article = CrimeCodeData.allArticles.firstOrNull { it.id == articleId }
        if (article != null) {
            _activeArticleDetail.value = article
        }
    }

    fun closeArticleDetail() {
        _activeArticleDetail.value = null
    }

    fun openUupDetail(rule: UupRule) {
        _activeUupDetail.value = rule
    }

    fun closeUupDetail() {
        _activeUupDetail.value = null
    }

    private data class Tuple4<A, B, C, D>(val a: A, val b: B, val c: C, val d: D)
    private data class Tuple5<A, B, C, D, E>(val a: A, val b: B, val c: C, val d: D, val e: E)
}
