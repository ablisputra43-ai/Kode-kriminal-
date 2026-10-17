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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import com.example.model.StarTierGroup
import com.example.ui.theme.BrandPrimary
import com.example.ui.theme.LightBorder
import com.example.ui.theme.LightSurface
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
fun StarTierCard(
    tierGroup: StarTierGroup,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit,
    onArticleClick: (CrimeArticle) -> Unit,
    modifier: Modifier = Modifier
) {
    val (badgeBg, badgeText, badgeBorder) = when (tierGroup.stars) {
        6 -> Triple(StarTier6Bg, StarTier6Text, StarTier6Border)
        5 -> Triple(StarTier5Bg, StarTier5Text, StarTier5Border)
        4 -> Triple(StarTier4Bg, StarTier4Text, StarTier4Border)
        3 -> Triple(StarTier3Bg, StarTier3Text, StarTier3Border)
        2 -> Triple(StarTier2Bg, StarTier2Text, StarTier2Border)
        1 -> Triple(StarTier1Bg, StarTier1Text, StarTier1Border)
        else -> Triple(StarTier0Bg, StarTier0Text, StarTier0Border)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("star_tier_card_${tierGroup.stars}"),
        colors = CardDefaults.cardColors(containerColor = LightSurface),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(
            width = if (isExpanded) 1.6.dp else 1.2.dp,
            color = if (isExpanded) badgeText else OutlineDistinct
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onToggleExpand)
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(badgeBg)
                                .border(1.dp, badgeBorder, RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = if (tierGroup.stars > 0) "★".repeat(tierGroup.stars) else "⚡ KHUSUS",
                                color = badgeText,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Black
                            )
                        }

                        Text(
                            text = tierGroup.title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = tierGroup.subtitle,
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
                            text = "${tierGroup.articles.size} Pasal",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = badgeText
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

            // Expanded article list
            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    tierGroup.articles.forEach { article ->
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
