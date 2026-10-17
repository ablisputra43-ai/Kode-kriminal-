package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CrimeArticle
import com.example.model.CrimeChapter
import com.example.ui.theme.BrandPrimary
import com.example.ui.theme.FineBg
import com.example.ui.theme.FineBorder
import com.example.ui.theme.FineText
import com.example.ui.theme.LightBorder
import com.example.ui.theme.LightSurface
import com.example.ui.theme.NoteBg
import com.example.ui.theme.NoteBorder
import com.example.ui.theme.NoteText
import com.example.ui.theme.OutlineDistinct
import com.example.ui.theme.StarTier0Bg
import com.example.ui.theme.StarTier0Border
import com.example.ui.theme.StarTier0Text
import com.example.ui.theme.StarTier1Bg
import com.example.ui.theme.StarTier1Border
import com.example.ui.theme.StarTier1Text
import com.example.ui.theme.StarTier2Bg
import com.example.ui.theme.StarTier2Border
import com.example.ui.theme.StarTier2Text
import com.example.ui.theme.StarTier3Bg
import com.example.ui.theme.StarTier3Border
import com.example.ui.theme.StarTier3Text
import com.example.ui.theme.StarTier4Bg
import com.example.ui.theme.StarTier4Border
import com.example.ui.theme.StarTier4Text
import com.example.ui.theme.StarTier5Bg
import com.example.ui.theme.StarTier5Border
import com.example.ui.theme.StarTier5Text
import com.example.ui.theme.StarTier6Bg
import com.example.ui.theme.StarTier6Border
import com.example.ui.theme.StarTier6Text
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun ChapterAccordionCard(
    chapter: CrimeChapter,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit,
    onArticleClick: (CrimeArticle) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("chapter_card_${chapter.roman}"),
        colors = CardDefaults.cardColors(containerColor = LightSurface),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(
            width = if (isExpanded) 1.6.dp else 1.2.dp,
            color = if (isExpanded) BrandPrimary else OutlineDistinct
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Chapter Header Clickable
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onToggleExpand)
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFFE8F3EB))
                                .border(1.dp, Color(0xFFA5C4AF), RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "BAB ${chapter.roman}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = BrandPrimary
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = chapter.title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "⚖️ Pasal ${chapter.roman} — ${chapter.subtitle}",
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFF0F4F1))
                            .border(1.dp, LightBorder, RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "${chapter.articles.size} Pasal",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = BrandPrimary
                        )
                    }

                    Spacer(modifier = Modifier.width(6.dp))

                    Icon(
                        imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = if (isExpanded) "Ciutkan" else "Perluas",
                        tint = BrandPrimary,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            // Expanded Article List
            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    chapter.articles.forEach { article ->
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = LightBorder
                        )

                        ArticleRowItem(
                            article = article,
                            onClick = { onArticleClick(article) }
                        )
                    }
                }
            }
        }
    }
}

/**
 * Clean, uncluttered article row with clear outlines
 */
@OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)
@Composable
fun ArticleRowItem(
    article: CrimeArticle,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag("article_row_${article.id}"),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 13.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Article number badge with distinct border
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFE8F3EB))
                    .border(1.dp, Color(0xFFA5C4AF), RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 5.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${article.id} ${article.icon}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = BrandPrimary
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Description + Star Rating & Tags
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = article.description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextPrimary,
                    lineHeight = 19.sp
                )

                Spacer(modifier = Modifier.height(5.dp))

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Star & Level Badge with clear border
                    LevelBadge(article = article)

                    if (!article.note.isNullOrBlank()) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(NoteBg)
                                .border(1.dp, NoteBorder, RoundedCornerShape(6.dp))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "📌 Catatan",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = NoteText
                            )
                        }
                    }

                    if (!article.fine.isNullOrBlank()) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(FineBg)
                                .border(1.dp, FineBorder, RoundedCornerShape(6.dp))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "💰 Denda",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = FineText
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Subtle chevron indicator indicating clickable details
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Buka Detail",
                tint = Color(0xFF90A4AE),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun LevelBadge(article: CrimeArticle) {
    val (bgColor, textColor, borderColor) = when (article.starRating) {
        6 -> Triple(StarTier6Bg, StarTier6Text, StarTier6Border)
        5 -> Triple(StarTier5Bg, StarTier5Text, StarTier5Border)
        4 -> Triple(StarTier4Bg, StarTier4Text, StarTier4Border)
        3 -> Triple(StarTier3Bg, StarTier3Text, StarTier3Border)
        2 -> Triple(StarTier2Bg, StarTier2Text, StarTier2Border)
        1 -> Triple(StarTier1Bg, StarTier1Text, StarTier1Border)
        else -> Triple(StarTier0Bg, StarTier0Text, StarTier0Border)
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bgColor)
            .border(1.dp, borderColor, RoundedCornerShape(6.dp))
            .padding(horizontal = 7.dp, vertical = 2.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = if (article.starRating > 0) "★".repeat(article.starRating) else "⚡",
                fontSize = 11.sp,
                color = textColor,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = article.level,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }
    }
}
