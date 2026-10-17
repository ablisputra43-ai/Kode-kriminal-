package com.example.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.model.CrimeArticle
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
fun ArticleDetailDialog(
    article: CrimeArticle,
    isFavorite: Boolean,
    onDismiss: () -> Unit,
    onToggleFavorite: () -> Unit
) {
    val context = LocalContext.current
    val (badgeBg, badgeText, badgeBorder) = when (article.starRating) {
        6 -> Triple(StarTier6Bg, StarTier6Text, StarTier6Border)
        5 -> Triple(StarTier5Bg, StarTier5Text, StarTier5Border)
        4 -> Triple(StarTier4Bg, StarTier4Text, StarTier4Border)
        3 -> Triple(StarTier3Bg, StarTier3Text, StarTier3Border)
        2 -> Triple(StarTier2Bg, StarTier2Text, StarTier2Border)
        1 -> Triple(StarTier1Bg, StarTier1Text, StarTier1Border)
        else -> Triple(StarTier0Bg, StarTier0Text, StarTier0Border)
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .clip(RoundedCornerShape(18.dp))
                .testTag("article_detail_dialog"),
            color = LightSurface,
            border = BorderStroke(1.5.dp, OutlineDistinct),
            tonalElevation = 6.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                // Header (matching HTML pophead: background #173f2a, white text)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BrandPrimary)
                        .padding(horizontal = 20.dp, vertical = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${article.id} ${article.icon}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )

                        IconButton(
                            onClick = onDismiss,
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.2f))
                                .testTag("close_popup_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Tutup",
                                tint = Color.White
                            )
                        }
                    }
                }

                // Body content
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    // Chapter breadcrumb label
                    Text(
                        text = "BAB ${article.chapterRoman} — ${article.chapterTitle} • Pasal ${article.chapterRoman}",
                        fontSize = 12.sp,
                        color = TextSecondary,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    // Article Description
                    Text(
                        text = article.description,
                        fontSize = 17.sp,
                        lineHeight = 25.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Tingkat Pencarian badge with star visualization and clear border
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(badgeBg)
                            .border(1.dp, badgeBorder, RoundedCornerShape(10.dp))
                            .padding(horizontal = 14.dp, vertical = 8.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = if (article.starRating > 0) "★".repeat(article.starRating) else "⚡",
                                color = badgeText,
                                fontWeight = FontWeight.Black,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Tingkat Pencarian: ${article.level}",
                                color = badgeText,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        }
                    }

                    // Note box (📌 Catatan) with clear outline
                    if (!article.note.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(NoteBg)
                                .border(1.dp, NoteBorder, RoundedCornerShape(10.dp))
                                .padding(14.dp)
                        ) {
                            Text(
                                text = "📌 ${article.note}",
                                color = NoteText,
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    // Fine box (💰 Denda) with clear outline
                    if (!article.fine.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(FineBg)
                                .border(1.dp, FineBorder, RoundedCornerShape(10.dp))
                                .padding(14.dp)
                        ) {
                            Text(
                                text = "💰 Denda: ${article.fine}",
                                color = FineText,
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Favorite Toggle Button with clear border
                    Button(
                        onClick = onToggleFavorite,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isFavorite) Color(0xFFFFF3CD) else Color(0xFFE8F3EB),
                            contentColor = if (isFavorite) Color(0xFF856404) else BrandPrimary
                        ),
                        border = BorderStroke(
                            1.2.dp,
                            if (isFavorite) Color(0xFFFFD54F) else Color(0xFFA5C4AF)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("favorite_button")
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Star else Icons.Outlined.StarBorder,
                            contentDescription = if (isFavorite) "Hapus dari Favorit" else "Tambah ke Favorit",
                            tint = if (isFavorite) Color(0xFFD48806) else BrandPrimary,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isFavorite) "Pasal Ditandai Favorit (Ketuk untuk Batal)" else "Tambahkan ke Tab Favorit",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Secondary Action Buttons (Salin & Bagikan) with clear borders
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Copy button
                        FilledTonalButton(
                            onClick = {
                                val textToCopy = buildString {
                                    append("Pasal ${article.id} (${article.chapterTitle})\n")
                                    append("${article.description}\n")
                                    append("Tingkat: ${article.level} (${article.tierLabel})")
                                    if (article.note != null) append("\nCatatan: ${article.note}")
                                    if (article.fine != null) append("\nDenda: ${article.fine}")
                                }
                                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                val clip = ClipData.newPlainText("Pasal ${article.id}", textToCopy)
                                clipboard.setPrimaryClip(clip)
                                Toast.makeText(context, "Pasal ${article.id} disalin ke papan klip", Toast.LENGTH_SHORT).show()
                            },
                            border = BorderStroke(1.dp, LightBorder),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .testTag("copy_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = "Salin",
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Salin", fontSize = 13.sp)
                        }

                        // Share button
                        FilledTonalButton(
                            onClick = {
                                val shareText = buildString {
                                    append("📜 KODE KRIMINAL\n")
                                    append("Pasal ${article.id}: ${article.description}\n")
                                    append("Tingkat: ${article.level}\n")
                                    if (article.note != null) append("Catatan: ${article.note}\n")
                                    if (article.fine != null) append("Denda: ${article.fine}\n")
                                }
                                val sendIntent = Intent().apply {
                                    action = Intent.ACTION_SEND
                                    putExtra(Intent.EXTRA_TEXT, shareText)
                                    type = "text/plain"
                                }
                                context.startActivity(Intent.createChooser(sendIntent, "Bagikan Pasal ${article.id}"))
                            },
                            border = BorderStroke(1.dp, LightBorder),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .testTag("share_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Bagikan",
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Bagikan", fontSize = 13.sp)
                        }
                    }
                }
            }
        }
    }
}
