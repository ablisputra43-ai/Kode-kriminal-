package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.CloseFullscreen
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.OpenInFull
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.model.CrimeArticle
import com.example.model.UupRule
import com.example.ui.AppMainTab
import com.example.ui.CrimeCodeViewModel
import com.example.ui.CrimeNavTab
import com.example.ui.CrimeUiState
import com.example.ui.FilterAttribute
import com.example.ui.components.ArticleDetailDialog
import com.example.ui.components.ArticleRowItem
import com.example.ui.components.ChapterAccordionCard
import com.example.ui.components.DashboardView
import com.example.ui.components.EmsSopView
import com.example.ui.components.HeroBox
import com.example.ui.components.SearchResultsOverlay
import com.example.ui.components.StarTierCard
import com.example.ui.components.UudRoleplayView
import com.example.ui.components.UupDetailDialog
import com.example.ui.theme.BrandGold
import com.example.ui.theme.BrandPrimary
import com.example.ui.theme.LightBg
import com.example.ui.theme.LightBorder
import com.example.ui.theme.LightSurface
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.OutlineDistinct
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val viewModel: CrimeCodeViewModel = viewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                MainAppScreen(
                    uiState = uiState,
                    onSelectMainTab = viewModel::setAppMainTab,
                    onSelectCrimeNavTab = viewModel::setCrimeNavTab,
                    onSearchChange = viewModel::onSearchQueryChanged,
                    onClearSearch = viewModel::clearSearch,
                    onSelectStarFilter = viewModel::setStarFilter,
                    onSelectAttributeFilter = viewModel::setAttributeFilter,
                    onResetFilters = viewModel::resetFilters,
                    onToggleFavorite = viewModel::toggleFavorite,
                    onToggleChapter = viewModel::toggleChapterExpansion,
                    onToggleStarTier = viewModel::toggleStarTierExpansion,
                    onExpandAll = viewModel::expandAll,
                    onCollapseAll = viewModel::collapseAll,
                    onOpenArticle = viewModel::openArticleDetail,
                    onOpenArticleById = viewModel::openArticleById,
                    onCloseArticle = viewModel::closeArticleDetail,
                    onOpenUupDetail = viewModel::openUupDetail,
                    onCloseUupDetail = viewModel::closeUupDetail
                )
            }
        }
    }
}

@Composable
fun MainAppScreen(
    uiState: CrimeUiState,
    onSelectMainTab: (AppMainTab) -> Unit,
    onSelectCrimeNavTab: (CrimeNavTab) -> Unit,
    onSearchChange: (String) -> Unit,
    onClearSearch: () -> Unit,
    onSelectStarFilter: (Int?) -> Unit,
    onSelectAttributeFilter: (FilterAttribute) -> Unit,
    onResetFilters: () -> Unit,
    onToggleFavorite: (String) -> Unit,
    onToggleChapter: (String) -> Unit,
    onToggleStarTier: (Int) -> Unit,
    onExpandAll: () -> Unit,
    onCollapseAll: () -> Unit,
    onOpenArticle: (CrimeArticle) -> Unit,
    onOpenArticleById: (String) -> Unit,
    onCloseArticle: () -> Unit,
    onOpenUupDetail: (UupRule) -> Unit,
    onCloseUupDetail: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = LightBg
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding())
        ) {
            // Header Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BrandPrimary)
                    .windowInsetsPadding(WindowInsets.statusBars)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(Color(0xFF224230))
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "KOTA 5 RIORISE",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Black,
                                        color = Color(0xFFA5D6A7),
                                        letterSpacing = 0.8.sp
                                    )
                                }
                                Text(
                                    text = "•",
                                    fontSize = 10.sp,
                                    color = Color(0xFF81C784)
                                )
                                Text(
                                    text = "RRPD S5",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color(0xFFFFD54F),
                                    letterSpacing = 0.8.sp
                                )
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = when (uiState.appMainTab) {
                                    AppMainTab.DASHBOARD -> "🛡️ PUSAT KOMANDO DASBOR"
                                    AppMainTab.KODE_KRIMINAL -> "📜 KODE KRIMINAL"
                                    AppMainTab.SOP_EMS -> "🚑 SOP PENJAGAAN EMS"
                                    AppMainTab.UUD_ROLEPLAY -> "⚖️ UUD ROLEPLAY KOTA 5"
                                },
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White,
                                letterSpacing = 0.5.sp
                            )
                        }
                    }

                    // Only show Search in Kode Kriminal tab or Dashboard
                    if (uiState.appMainTab == AppMainTab.KODE_KRIMINAL || uiState.appMainTab == AppMainTab.DASHBOARD) {
                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = uiState.searchQuery,
                            onValueChange = {
                                onSearchChange(it)
                                if (uiState.appMainTab == AppMainTab.DASHBOARD && it.isNotEmpty()) {
                                    onSelectMainTab(AppMainTab.KODE_KRIMINAL)
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .testTag("search_input"),
                            placeholder = {
                                Text(
                                    "🔎 Cari nomor pasal (misal: 4.1) atau kata kunci...",
                                    fontSize = 13.sp,
                                    color = Color.Gray
                                )
                            },
                            trailingIcon = {
                                if (uiState.searchQuery.isNotEmpty()) {
                                    IconButton(
                                        onClick = onClearSearch,
                                        modifier = Modifier.testTag("clear_search_button")
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Clear,
                                            contentDescription = "Hapus Pencarian",
                                            tint = BrandPrimary
                                        )
                                    }
                                }
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                focusedTextColor = TextPrimary,
                                unfocusedTextColor = TextPrimary,
                                focusedBorderColor = Color(0xFFA5C4AF),
                                unfocusedBorderColor = Color.White
                            ),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                            keyboardActions = KeyboardActions(onSearch = { focusManager.clearFocus() })
                        )

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Ketik nomor pasal untuk membuka popup rincian secara instan",
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.85f),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            // Top Primary Navigation: 3 Tab Panel Utama + Halaman Dasbor (Presisi & Bebas Penyusutan)
            ScrollableTabRow(
                selectedTabIndex = when (uiState.appMainTab) {
                    AppMainTab.DASHBOARD -> 0
                    AppMainTab.KODE_KRIMINAL -> 1
                    AppMainTab.SOP_EMS -> 2
                    AppMainTab.UUD_ROLEPLAY -> 3
                },
                edgePadding = 10.dp,
                containerColor = LightSurface,
                contentColor = BrandPrimary,
                indicator = { tabPositions ->
                    val index = when (uiState.appMainTab) {
                        AppMainTab.DASHBOARD -> 0
                        AppMainTab.KODE_KRIMINAL -> 1
                        AppMainTab.SOP_EMS -> 2
                        AppMainTab.UUD_ROLEPLAY -> 3
                    }
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[index]),
                        color = when (index) {
                            2 -> Color(0xFF0D47A1) // Blue indicator for EMS
                            3 -> Color(0xFFC62828) // Red indicator for UUD
                            else -> BrandPrimary
                        },
                        height = 3.dp
                    )
                },
                divider = {
                    HorizontalDivider(thickness = 1.2.dp, color = OutlineDistinct)
                }
            ) {
                // Dasbor
                Tab(
                    selected = uiState.appMainTab == AppMainTab.DASHBOARD,
                    onClick = { onSelectMainTab(AppMainTab.DASHBOARD) },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Dashboard,
                                contentDescription = null,
                                tint = if (uiState.appMainTab == AppMainTab.DASHBOARD) BrandPrimary else TextSecondary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Dasbor",
                                fontSize = 13.sp,
                                fontWeight = if (uiState.appMainTab == AppMainTab.DASHBOARD) FontWeight.Black else FontWeight.Medium,
                                color = if (uiState.appMainTab == AppMainTab.DASHBOARD) BrandPrimary else TextSecondary
                            )
                        }
                    }
                )

                // Panel 1: Kode Kriminal
                Tab(
                    selected = uiState.appMainTab == AppMainTab.KODE_KRIMINAL,
                    onClick = { onSelectMainTab(AppMainTab.KODE_KRIMINAL) },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.FolderSpecial,
                                contentDescription = null,
                                tint = if (uiState.appMainTab == AppMainTab.KODE_KRIMINAL) BrandPrimary else TextSecondary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Kode Kriminal",
                                fontSize = 13.sp,
                                fontWeight = if (uiState.appMainTab == AppMainTab.KODE_KRIMINAL) FontWeight.Black else FontWeight.Medium,
                                color = if (uiState.appMainTab == AppMainTab.KODE_KRIMINAL) BrandPrimary else TextSecondary
                            )
                        }
                    }
                )

                // Panel 2: SOP EMS
                Tab(
                    selected = uiState.appMainTab == AppMainTab.SOP_EMS,
                    onClick = { onSelectMainTab(AppMainTab.SOP_EMS) },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.LocalHospital,
                                contentDescription = null,
                                tint = if (uiState.appMainTab == AppMainTab.SOP_EMS) Color(0xFF0D47A1) else TextSecondary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "SOP EMS",
                                fontSize = 13.sp,
                                fontWeight = if (uiState.appMainTab == AppMainTab.SOP_EMS) FontWeight.Black else FontWeight.Medium,
                                color = if (uiState.appMainTab == AppMainTab.SOP_EMS) Color(0xFF0D47A1) else TextSecondary
                            )
                        }
                    }
                )

                // Panel 3: UUD Roleplay Kota 5
                Tab(
                    selected = uiState.appMainTab == AppMainTab.UUD_ROLEPLAY,
                    onClick = { onSelectMainTab(AppMainTab.UUD_ROLEPLAY) },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Gavel,
                                contentDescription = null,
                                tint = if (uiState.appMainTab == AppMainTab.UUD_ROLEPLAY) Color(0xFFC62828) else TextSecondary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "UUD Roleplay",
                                fontSize = 13.sp,
                                fontWeight = if (uiState.appMainTab == AppMainTab.UUD_ROLEPLAY) FontWeight.Black else FontWeight.Medium,
                                color = if (uiState.appMainTab == AppMainTab.UUD_ROLEPLAY) Color(0xFFC62828) else TextSecondary
                            )
                        }
                    }
                )
            }

            // Sub Navigation & Content based on AppMainTab
            when (uiState.appMainTab) {
                // 1. DASBOR PAGE
                AppMainTab.DASHBOARD -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        item {
                            DashboardView(
                                onNavigateTab = onSelectMainTab,
                                onOpenArticleById = onOpenArticleById,
                                onOpenUupDetail = onOpenUupDetail
                            )
                        }
                    }
                }

                // 2. PANEL PERTAMA: KODE KRIMINAL
                AppMainTab.KODE_KRIMINAL -> {
                    Column(modifier = Modifier.fillMaxSize()) {
                        // Sub Tabs (21 Bab, Bintang 1-6, Favorit)
                        TabRow(
                            selectedTabIndex = when (uiState.activeNavTab) {
                                CrimeNavTab.ALL_CHAPTERS -> 0
                                CrimeNavTab.BY_STARS -> 1
                                CrimeNavTab.FAVORITES -> 2
                            },
                            containerColor = Color(0xFFF9FAF9),
                            contentColor = BrandPrimary,
                            indicator = { tabPositions ->
                                val index = when (uiState.activeNavTab) {
                                    CrimeNavTab.ALL_CHAPTERS -> 0
                                    CrimeNavTab.BY_STARS -> 1
                                    CrimeNavTab.FAVORITES -> 2
                                }
                                TabRowDefaults.SecondaryIndicator(
                                    modifier = Modifier.tabIndicatorOffset(tabPositions[index]),
                                    color = BrandPrimary,
                                    height = 2.5.dp
                                )
                            },
                            divider = {
                                HorizontalDivider(thickness = 1.dp, color = LightBorder)
                            }
                        ) {
                            Tab(
                                selected = uiState.activeNavTab == CrimeNavTab.ALL_CHAPTERS,
                                onClick = { onSelectCrimeNavTab(CrimeNavTab.ALL_CHAPTERS) },
                                text = {
                                    Text(
                                        text = "21 Bab",
                                        fontSize = 12.sp,
                                        fontWeight = if (uiState.activeNavTab == CrimeNavTab.ALL_CHAPTERS) FontWeight.Bold else FontWeight.Medium
                                    )
                                }
                            )

                            Tab(
                                selected = uiState.activeNavTab == CrimeNavTab.BY_STARS,
                                onClick = { onSelectCrimeNavTab(CrimeNavTab.BY_STARS) },
                                text = {
                                    Text(
                                        text = "Bintang (1–6)",
                                        fontSize = 12.sp,
                                        fontWeight = if (uiState.activeNavTab == CrimeNavTab.BY_STARS) FontWeight.Bold else FontWeight.Medium
                                    )
                                }
                            )

                            Tab(
                                selected = uiState.activeNavTab == CrimeNavTab.FAVORITES,
                                onClick = { onSelectCrimeNavTab(CrimeNavTab.FAVORITES) },
                                text = {
                                    Text(
                                        text = "Favorit (${uiState.favoriteArticleIds.size})",
                                        fontSize = 12.sp,
                                        fontWeight = if (uiState.activeNavTab == CrimeNavTab.FAVORITES) FontWeight.Bold else FontWeight.Medium
                                    )
                                }
                            )
                        }

                        // Dropdown Filters
                        FilterDropdownBar(
                            selectedStar = uiState.selectedStarFilter,
                            selectedAttribute = uiState.selectedAttributeFilter,
                            onSelectStar = onSelectStarFilter,
                            onSelectAttribute = onSelectAttributeFilter,
                            onReset = onResetFilters
                        )

                        // Stats & Expand/Collapse row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            val statsText = when (uiState.activeNavTab) {
                                CrimeNavTab.ALL_CHAPTERS -> "${uiState.filteredChapters.size} Bab • ${uiState.filteredChapters.sumOf { it.articles.size }} Pasal"
                                CrimeNavTab.BY_STARS -> "${uiState.filteredStarGroups.size} Kelompok Bintang • ${uiState.filteredStarGroups.sumOf { it.articles.size }} Pasal"
                                CrimeNavTab.FAVORITES -> "${uiState.favoriteArticles.size} Pasal Favorit"
                            }

                            Text(
                                text = statsText,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextSecondary
                            )

                            if (uiState.activeNavTab != CrimeNavTab.FAVORITES) {
                                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    TextButton(
                                        onClick = onExpandAll,
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                                        modifier = Modifier.height(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.OpenInFull,
                                            contentDescription = null,
                                            modifier = Modifier.size(13.dp),
                                            tint = BrandPrimary
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Buka Semua", fontSize = 11.sp, color = BrandPrimary)
                                    }

                                    TextButton(
                                        onClick = onCollapseAll,
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                                        modifier = Modifier.height(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.CloseFullscreen,
                                            contentDescription = null,
                                            modifier = Modifier.size(13.dp),
                                            tint = BrandPrimary
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Tutup Semua", fontSize = 11.sp, color = BrandPrimary)
                                    }
                                }
                            }
                        }

                        // Content List
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        ) {
                            when (uiState.activeNavTab) {
                                CrimeNavTab.ALL_CHAPTERS -> {
                                    if (uiState.filteredChapters.isEmpty()) {
                                        EmptyStateView(query = uiState.searchQuery)
                                    } else {
                                        LazyColumn(
                                            modifier = Modifier.fillMaxSize(),
                                            contentPadding = PaddingValues(start = 14.dp, end = 14.dp, top = 6.dp, bottom = 24.dp),
                                            verticalArrangement = Arrangement.spacedBy(12.dp)
                                        ) {
                                            if (uiState.searchQuery.isEmpty() && uiState.selectedStarFilter == null && uiState.selectedAttributeFilter == FilterAttribute.ALL) {
                                                item { HeroBox() }
                                            }

                                            items(uiState.filteredChapters, key = { it.roman }) { chapter ->
                                                ChapterAccordionCard(
                                                    chapter = chapter,
                                                    isExpanded = uiState.expandedChapters.contains(chapter.roman),
                                                    onToggleExpand = { onToggleChapter(chapter.roman) },
                                                    onArticleClick = onOpenArticle
                                                )
                                            }
                                        }
                                    }
                                }

                                CrimeNavTab.BY_STARS -> {
                                    if (uiState.filteredStarGroups.isEmpty()) {
                                        EmptyStateView(query = uiState.searchQuery)
                                    } else {
                                        LazyColumn(
                                            modifier = Modifier.fillMaxSize(),
                                            contentPadding = PaddingValues(start = 14.dp, end = 14.dp, top = 6.dp, bottom = 24.dp),
                                            verticalArrangement = Arrangement.spacedBy(12.dp)
                                        ) {
                                            if (uiState.searchQuery.isEmpty() && uiState.selectedStarFilter == null && uiState.selectedAttributeFilter == FilterAttribute.ALL) {
                                                item { HeroBox() }
                                            }

                                            items(uiState.filteredStarGroups, key = { it.stars }) { group ->
                                                StarTierCard(
                                                    tierGroup = group,
                                                    isExpanded = uiState.expandedStarTiers.contains(group.stars),
                                                    onToggleExpand = { onToggleStarTier(group.stars) },
                                                    onArticleClick = onOpenArticle
                                                )
                                            }
                                        }
                                    }
                                }

                                CrimeNavTab.FAVORITES -> {
                                    if (uiState.favoriteArticleIds.isEmpty()) {
                                        FavoritesEmptyState()
                                    } else if (uiState.favoriteArticles.isEmpty()) {
                                        EmptyStateView(query = uiState.searchQuery)
                                    } else {
                                        LazyColumn(
                                            modifier = Modifier.fillMaxSize(),
                                            contentPadding = PaddingValues(start = 14.dp, end = 14.dp, top = 6.dp, bottom = 24.dp),
                                            verticalArrangement = Arrangement.spacedBy(10.dp)
                                        ) {
                                            items(uiState.favoriteArticles, key = { it.id }) { article ->
                                                Card(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    colors = CardDefaults.cardColors(containerColor = LightSurface),
                                                    shape = RoundedCornerShape(14.dp),
                                                    border = BorderStroke(1.4.dp, OutlineDistinct),
                                                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                                                ) {
                                                    ArticleRowItem(
                                                        article = article,
                                                        onClick = { onOpenArticle(article) }
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // Suggestions Dropdown Overlay
                            if (uiState.searchResults.isNotEmpty() && uiState.searchQuery.trim().isNotEmpty()) {
                                SearchResultsOverlay(
                                    results = uiState.searchResults,
                                    onSelectArticle = { article ->
                                        focusManager.clearFocus()
                                        onOpenArticle(article)
                                    },
                                    modifier = Modifier
                                        .padding(horizontal = 14.dp, vertical = 4.dp)
                                        .align(Alignment.TopCenter)
                                )
                            }
                        }
                    }
                }

                // 3. PANEL KEDUA: SOP PENJAGAAN EMS
                AppMainTab.SOP_EMS -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        item {
                            EmsSopView(
                                onSelectArticleId = { articleId ->
                                    onOpenArticleById(articleId)
                                }
                            )
                        }
                    }
                }

                // 4. PANEL KETIGA: UUD ROLEPLAY KOTA 5
                AppMainTab.UUD_ROLEPLAY -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        item {
                            UudRoleplayView(
                                onSelectRule = onOpenUupDetail
                            )
                        }
                    }
                }
            }
        }
    }

    // Article Detail Modal
    uiState.activeArticleDetail?.let { article ->
        ArticleDetailDialog(
            article = article,
            isFavorite = uiState.favoriteArticleIds.contains(article.id),
            onDismiss = onCloseArticle,
            onToggleFavorite = { onToggleFavorite(article.id) }
        )
    }

    // UUP Roleplay Rule Detail Modal
    uiState.activeUupDetail?.let { rule ->
        UupDetailDialog(
            rule = rule,
            onDismiss = onCloseUupDetail
        )
    }
}

/**
 * Dropdown filter menu with clear, distinct outline borders
 */
@Composable
fun FilterDropdownBar(
    selectedStar: Int?,
    selectedAttribute: FilterAttribute,
    onSelectStar: (Int?) -> Unit,
    onSelectAttribute: (FilterAttribute) -> Unit,
    onReset: () -> Unit
) {
    var starDropdownExpanded by remember { mutableStateOf(false) }
    var attrDropdownExpanded by remember { mutableStateOf(false) }

    val starLabels = listOf(
        null to "Semua Bintang",
        6 to "★★★★★★ Bintang 6",
        5 to "★★★★★ Bintang 5",
        4 to "★★★★ Bintang 4",
        3 to "★★★ Bintang 3",
        2 to "★★ Bintang 2",
        1 to "★ Bintang 1",
        0 to "⚡ Tingkat Khusus"
    )

    val currentStarLabel = starLabels.firstOrNull { it.first == selectedStar }?.second ?: "Semua Bintang"
    val isFilterActive = selectedStar != null || selectedAttribute != FilterAttribute.ALL

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Dropdown 1: Bintang Filter with distinct outline
        Box(modifier = Modifier.weight(1.2f)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { starDropdownExpanded = true }
                    .testTag("filter_star_dropdown"),
                colors = CardDefaults.cardColors(containerColor = LightSurface),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.4.dp, if (selectedStar != null) BrandPrimary else OutlineDistinct),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = currentStarLabel,
                        fontSize = 12.sp,
                        fontWeight = if (selectedStar != null) FontWeight.Bold else FontWeight.Medium,
                        color = if (selectedStar != null) BrandPrimary else TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Pilih Bintang",
                        tint = BrandPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            DropdownMenu(
                expanded = starDropdownExpanded,
                onDismissRequest = { starDropdownExpanded = false }
            ) {
                starLabels.forEach { (starVal, label) ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = label,
                                fontSize = 13.sp,
                                fontWeight = if (selectedStar == starVal) FontWeight.Bold else FontWeight.Normal,
                                color = if (selectedStar == starVal) BrandPrimary else TextPrimary
                            )
                        },
                        onClick = {
                            onSelectStar(starVal)
                            starDropdownExpanded = false
                        }
                    )
                }
            }
        }

        // Dropdown 2: Kategori Filter with distinct outline
        Box(modifier = Modifier.weight(1.1f)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { attrDropdownExpanded = true }
                    .testTag("filter_attr_dropdown"),
                colors = CardDefaults.cardColors(containerColor = LightSurface),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.4.dp, if (selectedAttribute != FilterAttribute.ALL) BrandPrimary else OutlineDistinct),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedAttribute.label,
                        fontSize = 12.sp,
                        fontWeight = if (selectedAttribute != FilterAttribute.ALL) FontWeight.Bold else FontWeight.Medium,
                        color = if (selectedAttribute != FilterAttribute.ALL) BrandPrimary else TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Pilih Kategori",
                        tint = BrandPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            DropdownMenu(
                expanded = attrDropdownExpanded,
                onDismissRequest = { attrDropdownExpanded = false }
            ) {
                FilterAttribute.entries.forEach { attr ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = attr.label,
                                fontSize = 13.sp,
                                fontWeight = if (selectedAttribute == attr) FontWeight.Bold else FontWeight.Normal,
                                color = if (selectedAttribute == attr) BrandPrimary else TextPrimary
                            )
                        },
                        onClick = {
                            onSelectAttribute(attr)
                            attrDropdownExpanded = false
                        }
                    )
                }
            }
        }

        // Reset Button (if active)
        if (isFilterActive) {
            IconButton(
                onClick = onReset,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.RestartAlt,
                    contentDescription = "Reset Filter",
                    tint = BrandPrimary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun FavoritesEmptyState() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFFFF7DF)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier.size(36.dp),
                tint = BrandGold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Belum Ada Pasal Favorit",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Buka pasal manapun dari daftar 21 Bab atau Bintang, lalu ketuk 'Tambahkan ke Tab Favorit' untuk menampilkannya di sini.",
            fontSize = 13.sp,
            color = TextSecondary,
            textAlign = TextAlign.Center,
            lineHeight = 19.sp
        )
    }
}

@Composable
fun EmptyStateView(query: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier.size(48.dp),
            tint = TextSecondary.copy(alpha = 0.5f)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Pasal atau kata yang dicari tidak ditemukan.",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = TextSecondary,
            textAlign = TextAlign.Center
        )
        if (query.isNotEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Tidak ada hasil untuk '$query'. Periksa kembali ejaan atau nomor pasal.",
                fontSize = 12.sp,
                color = TextSecondary.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
        }
    }
}
