package com.example.ui.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Warning
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.EmsSopData
import com.example.model.EmsCommonCrime
import com.example.model.EmsMelamunStep
import com.example.model.EmsRestrictedArea
import com.example.ui.theme.BrandPrimary
import com.example.ui.theme.LightBorder
import com.example.ui.theme.LightSurface
import com.example.ui.theme.OutlineDistinct
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
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun EmsSopView(
    onSelectArticleId: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("ems_sop_view"),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Modern Military Tactical Header: RRPD S5 SOP PENJAGAAN EMS (KOTA 5)
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0F2618)),
            border = BorderStroke(1.5.dp, Color(0xFF2E543A)),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF1E3F2A))
                            .border(1.dp, Color(0xFF388E3C), RoundedCornerShape(4.dp))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = "[TAC-MED // RRPD S5]",
                            fontWeight = FontWeight.Black,
                            fontSize = 10.sp,
                            color = Color(0xFFA5D6A7),
                            letterSpacing = 1.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Security,
                            contentDescription = null,
                            tint = Color(0xFFFFD54F),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "KOTA 5 RIORISE",
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = Color(0xFFFFD54F)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF1E3F2A)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🚑", fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = "SOP PENJAGAAN FASILITAS EMS",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            letterSpacing = 0.5.sp
                        )
                        Text(
                            text = "Standar Operasional Kepolisian S5 & Medis Riorise",
                            fontSize = 12.sp,
                            color = Color(0xFFC8E6C9)
                        )
                    }
                }
            }
        }

        // Section 1: KETENTUAN PERSONIL
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = LightSurface),
            border = BorderStroke(1.4.dp, OutlineDistinct),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Group,
                        contentDescription = null,
                        tint = BrandPrimary,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "1. KETENTUAN PERSONIL JAGA",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        color = BrandPrimary,
                        letterSpacing = 0.5.sp
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // Minimal 3
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFE8F5E9))
                            .border(1.2.dp, Color(0xFFA5D6A7), RoundedCornerShape(10.dp))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "MINIMAL",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2E7D32)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "👤👤👤", fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "3 Personil",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFF1B5E20)
                            )
                        }
                    }

                    // Maksimal 4
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFE3F2FD))
                            .border(1.2.dp, Color(0xFF90CAF9), RoundedCornerShape(10.dp))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "MAKSIMAL",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1565C0)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "👤👤👤👤", fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "4 Personil",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFF0D47A1)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFF1F8F3))
                        .border(1.dp, Color(0xFFA5D6A7), RoundedCornerShape(8.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "📌 Aturan Wajib: Penjagaan EMS wajib diisi minimal 3 personil dan maksimal 4 personil bertugas serentak.",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF1E4620),
                        lineHeight = 16.sp
                    )
                }
            }
        }

        // Section 2: PENJAGAAN AREA TERLARANG EMS (Sleek cards layout to prevent squishing)
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = LightSurface),
            border = BorderStroke(1.4.dp, OutlineDistinct),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Block,
                        contentDescription = null,
                        tint = Color(0xFFC62828),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "2. AREA TERLARANG RUMAH SAKIT",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFFC62828),
                        letterSpacing = 0.5.sp
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Area privat rumah sakit yang dilarang keras dimasuki oleh warga sipil:",
                    fontSize = 12.sp,
                    color = TextSecondary
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Displaying restricted areas with generous padding so text never breaks awkwardly
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    EmsSopData.restrictedAreas.forEach { area ->
                        RestrictedAreaCard(area = area)
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFFFEBEE))
                        .border(1.dp, Color(0xFFEF9A9A), RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🚫 Pelanggaran masuk area terlarang dikenakan sanksi Pasal B3",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFFC62828),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Section 3: SOP MEMPERINGATKAN WARGA (Precision Process Timeline)
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = LightSurface),
            border = BorderStroke(1.4.dp, OutlineDistinct),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = BrandPrimary,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "3. SOP TAHAPAN PERINGATAN WARGA",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        color = BrandPrimary,
                        letterSpacing = 0.5.sp
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Structured sequential step items (No squishing, ample room for text)
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    WarningStepRow(
                        step = "1",
                        title = "BERI ISYARAT TANGAN",
                        badge = "3 KALI",
                        icon = "✋",
                        desc = "Beri isyarat visual dan gerakan tangan secara tegas menghadap ke arah warga.",
                        color = Color(0xFF1565C0)
                    )
                    WarningStepRow(
                        step = "2",
                        title = "BERI PERINGATAN VOIP",
                        badge = "3 KALI",
                        icon = "🗣️",
                        desc = "Gunakan saluran suara / mikrofon VOIP resmi memerintahkan warga untuk menjauh.",
                        color = Color(0xFFE65100)
                    )
                    WarningStepRow(
                        step = "3",
                        title = "TINDAK SESUAI HUKUM",
                        badge = "PASAL B3",
                        icon = "⚖️",
                        desc = "Warga masih bebal dan mengabaikan? Segera kenakan pasal pelanggaran KUHP.",
                        color = Color(0xFFC62828)
                    )
                }
            }
        }

        // Section 4: PASAL YANG SERING TERJADI DI EMS
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = LightSurface),
            border = BorderStroke(1.4.dp, OutlineDistinct),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Gavel,
                            contentDescription = null,
                            tint = BrandPrimary,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "4. PASAL SERING TERJADI DI EMS",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black,
                            color = BrandPrimary,
                            letterSpacing = 0.5.sp
                        )
                    }

                    Text(
                        text = "Ketuk untuk Rincian",
                        fontSize = 11.sp,
                        color = BrandPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Table Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFE8F3EB))
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "PASAL",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        color = BrandPrimary,
                        modifier = Modifier.width(68.dp)
                    )
                    Text(
                        text = "PELANGGARAN",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        color = BrandPrimary,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "LEVEL",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        color = BrandPrimary,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(60.dp)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Table Rows
                EmsSopData.commonCrimes.forEach { crime ->
                    EmsCrimeRow(
                        crime = crime,
                        onClick = { onSelectArticleId(crime.articleId) }
                    )
                    HorizontalDivider(thickness = 0.8.dp, color = LightBorder)
                }
            }
        }

        // Section 5: SOP MENGHADAPI WARGA LOKAL YANG MELAMUN
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = LightSurface),
            border = BorderStroke(1.4.dp, OutlineDistinct),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "👁️", fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "5. SOP PENANGANAN WARGA MELAMUN (AFK)",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        color = BrandPrimary,
                        letterSpacing = 0.5.sp
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                EmsSopData.melamunSteps.forEach { step ->
                    MelamunStepItem(step = step)
                    if (step.stepNumber < 5) {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Pedoman Khusus Personil Jaga EMS RRPD S5",
                        fontSize = 11.sp,
                        color = TextSecondary
                    )
                    Text(
                        text = "#Kenoo_Paulo",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1565C0)
                    )
                }
            }
        }
    }
}

@Composable
private fun RestrictedAreaCard(area: EmsRestrictedArea) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFFFF7F7))
            .border(1.2.dp, Color(0xFFFFCDD2), RoundedCornerShape(8.dp))
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFFFFEBEE)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = area.icon, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = area.name,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFFB71C1C)
                )
                Text(
                    text = area.note,
                    fontSize = 11.sp,
                    color = TextSecondary,
                    lineHeight = 15.sp
                )
            }
        }
    }
}

@Composable
private fun WarningStepRow(
    step: String,
    title: String,
    badge: String,
    icon: String,
    desc: String,
    color: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF9FAF9))
            .border(1.2.dp, OutlineDistinct, RoundedCornerShape(8.dp))
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .clip(CircleShape)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = step,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = icon, fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = title,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Black,
                            color = TextPrimary
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(color.copy(alpha = 0.12f))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = badge,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black,
                            color = color
                        )
                    }
                }

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = desc,
                    fontSize = 11.sp,
                    color = TextSecondary,
                    lineHeight = 15.sp
                )
            }
        }
    }
}

@Composable
fun EmsCrimeRow(
    crime: EmsCommonCrime,
    onClick: () -> Unit
) {
    val (badgeBg, badgeText, badgeBorder) = when (crime.stars) {
        5 -> Triple(StarTier5Bg, StarTier5Text, StarTier5Border)
        4 -> Triple(StarTier4Bg, StarTier4Text, StarTier4Border)
        3 -> Triple(StarTier3Bg, StarTier3Text, StarTier3Border)
        2 -> Triple(StarTier2Bg, StarTier2Text, StarTier2Border)
        else -> Triple(StarTier1Bg, StarTier1Text, StarTier1Border)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 9.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(68.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFFE8F3EB))
                .border(1.dp, Color(0xFFA5C4AF), RoundedCornerShape(6.dp))
                .padding(vertical = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = crime.articleId,
                fontSize = 12.sp,
                fontWeight = FontWeight.Black,
                color = BrandPrimary
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "${crime.icon} ${crime.violation}",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimary,
            modifier = Modifier.weight(1f),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.width(6.dp))

        Box(
            modifier = Modifier
                .width(60.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(badgeBg)
                .border(1.dp, badgeBorder, RoundedCornerShape(6.dp))
                .padding(vertical = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = crime.levelCode,
                fontSize = 11.sp,
                fontWeight = FontWeight.Black,
                color = badgeText
            )
        }
    }
}

@Composable
fun MelamunStepItem(step: EmsMelamunStep) {
    val borderColor = when {
        step.isSuccess -> Color(0xFF81C784)
        step.isWarning -> Color(0xFFFFB74D)
        else -> LightBorder
    }

    val bgColor = when {
        step.isSuccess -> Color(0xFFE8F5E9)
        step.isWarning -> Color(0xFFFFF8E1)
        else -> Color(0xFFF9FAF9)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(bgColor)
            .border(1.2.dp, borderColor, RoundedCornerShape(8.dp))
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(BrandPrimary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${step.stepNumber}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = step.title,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = TextPrimary,
                        modifier = Modifier.weight(1f)
                    )

                    step.tag?.let { tag ->
                        Spacer(modifier = Modifier.width(4.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(
                                    if (step.isSuccess) Color(0xFF2E7D32)
                                    else if (step.isWarning) Color(0xFFE65100)
                                    else BrandPrimary
                                )
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = tag,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = step.description,
                    fontSize = 11.sp,
                    color = TextSecondary,
                    lineHeight = 15.sp
                )
            }
        }
    }
}
