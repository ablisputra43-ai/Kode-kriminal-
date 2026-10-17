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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
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
import com.example.data.CrimeCodeData
import com.example.data.EmsSopData
import com.example.model.UupRule
import com.example.ui.AppMainTab
import com.example.ui.theme.BrandGold
import com.example.ui.theme.BrandPrimary
import com.example.ui.theme.LightBorder
import com.example.ui.theme.LightSurface
import com.example.ui.theme.OutlineDistinct
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun DashboardView(
    onNavigateTab: (AppMainTab) -> Unit,
    onOpenArticleById: (String) -> Unit,
    onOpenUupDetail: (UupRule) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("dashboard_view"),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Modern Military Tactical Command Hero Banner
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF112519)),
            border = BorderStroke(1.5.dp, Color(0xFF2E543A)),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Tactical Top Callout
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF1E3D2B))
                            .border(1.dp, Color(0xFF3B6B4C), RoundedCornerShape(4.dp))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = "[TAC-POL // KOTA 5]",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFFA5D6A7),
                            letterSpacing = 1.sp
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF264733))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(6.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF69F0AE))
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "SIAGA 1 • AKTIF S5",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF81C784)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF1E3D2B))
                            .border(1.2.dp, Color(0xFF4C7D5C), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🛡️", fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "PUSAT KOMANDO TERPADU",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFFA5D6A7),
                            letterSpacing = 1.sp
                        )
                        Text(
                            text = "Kota 5 Riorise // RRPD S5",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            letterSpacing = 0.5.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Sistem referensi penegakan hukum roleplay Kepolisian Kota 5 Riorise: KUHP 21 Bab, SOP Penjagaan EMS Medis, dan UUD Regulasi Roleplay.",
                    fontSize = 12.sp,
                    color = Color(0xFFD6E6DB),
                    lineHeight = 17.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Precision Metrics Grid: 2x2 layout so text never shrinks or clips awkwardly
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DashboardMetricPill(
                        value = "62 Pasal",
                        label = "Kode Kriminal KUHP",
                        modifier = Modifier.weight(1f)
                    )
                    DashboardMetricPill(
                        value = "21 Bab",
                        label = "Klasifikasi Pidana",
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DashboardMetricPill(
                        value = "B1 - B6",
                        label = "Tingkat Bintang",
                        modifier = Modifier.weight(1f)
                    )
                    DashboardMetricPill(
                        value = "26 Aturan",
                        label = "UUD Roleplay Kota 5",
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // Section Title: 3 Main Tab Panels (Sesuai Permintaan: Sekarang Ada 3 Tab Panel)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .width(4.dp)
                        .height(18.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(BrandPrimary)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "3 TAB PANEL UTAMA KEPOLISIAN",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Black,
                    color = BrandPrimary,
                    letterSpacing = 0.5.sp
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFFE5EEE7))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            ) {
                Text(
                    text = "RRPD S5",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = BrandPrimary
                )
            }
        }

        // 3 Distinct Tactical Panel Navigation Cards:
        // Panel 1: Kode Kriminal
        TacticalPanelCard(
            panelNumber = "PANEL 1",
            title = "Kode Kriminal (KUHP)",
            subtitle = "21 Bab hukum pidana, pasal tingkat bintang 1–6, catatan khusus lisensi & kalkulator tilang.",
            icon = "📜",
            badgeText = "21 BAB • B1–B6",
            accentColor = BrandPrimary,
            tag = "btn_goto_kode_kriminal",
            onClick = { onNavigateTab(AppMainTab.KODE_KRIMINAL) }
        )

        // Panel 2: SOP Penjagaan EMS
        TacticalPanelCard(
            panelNumber = "PANEL 2",
            title = "SOP Penjagaan EMS",
            subtitle = "Prosedur personil jaga RS, proteksi area steril, tahapan peringatan & penanganan warga melamun.",
            icon = "🚑",
            badgeText = "MEDIS & FASILITAS",
            accentColor = Color(0xFF0D47A1),
            tag = "btn_goto_sop_ems",
            onClick = { onNavigateTab(AppMainTab.SOP_EMS) }
        )

        // Panel 3: UUD Roleplay Kota 5
        TacticalPanelCard(
            panelNumber = "PANEL 3",
            title = "UUD Roleplay Kota 5",
            subtitle = "Peraturan kepolisian Kota 5 Riorise: RDM, VDM, Combat Log, Power Gaming, dan sanksi penjara.",
            icon = "⚖️",
            badgeText = "26 PASAL UUP • 60 MNT",
            accentColor = Color(0xFFB71C1C),
            tag = "btn_goto_uud_roleplay",
            onClick = { onNavigateTab(AppMainTab.UUD_ROLEPLAY) }
        )

        // Quick Highlights: Emergency Codes
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
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
                            imageVector = Icons.Default.Warning,
                            contentDescription = null,
                            tint = Color(0xFFD32F2F),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "STATUS KODE DARURAT KEPOLISIAN",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black,
                            color = BrandPrimary
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFFFFEBEE))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "KOTA 5",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFFC62828)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    EmergencyCodeBadge(
                        code = "KODE 1",
                        label = "Situasi Aman",
                        color = Color(0xFF2E7D32),
                        modifier = Modifier.weight(1f)
                    )
                    EmergencyCodeBadge(
                        code = "KODE 2",
                        label = "Siaga / Pantau",
                        color = Color(0xFFF57F17),
                        modifier = Modifier.weight(1f)
                    )
                    EmergencyCodeBadge(
                        code = "KODE 3",
                        label = "Bantuan Sirene",
                        color = Color(0xFFE65100),
                        modifier = Modifier.weight(1f)
                    )
                    EmergencyCodeBadge(
                        code = "KODE 4",
                        label = "Darurat Tembak",
                        color = Color(0xFFC62828),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // Preview: UUD Roleplay Kota 5 (Interactive horizontal slider)
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
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
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Gavel,
                            contentDescription = null,
                            tint = BrandPrimary,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "ATURAN UUD ROLEPLAY KOTA 5",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Black,
                                color = BrandPrimary
                            )
                            Text(
                                text = "Undang-Undang Kepolisian Kota 5 Riorise",
                                fontSize = 11.sp,
                                color = TextSecondary
                            )
                        }
                    }

                    OutlinedButton(
                        onClick = { onNavigateTab(AppMainTab.UUD_ROLEPLAY) },
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                        modifier = Modifier.height(28.dp),
                        border = BorderStroke(1.dp, BrandPrimary)
                    ) {
                        Text(
                            text = "Lihat Semua",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = BrandPrimary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Scrollable horizontal cards of UUP items with clean, non-shrinking widths
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(EmsSopData.uupRules) { rule ->
                        Card(
                            modifier = Modifier
                                .width(140.dp)
                                .clickable { onOpenUupDetail(rule) },
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFF7FAF8)),
                            border = BorderStroke(1.2.dp, LightBorder)
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = rule.icon, fontSize = 16.sp)
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(Color(0xFFFFEBEE))
                                            .padding(horizontal = 5.dp, vertical = 2.dp)
                                    ) {
                                        Text(
                                            text = "${rule.penaltyMinutes}m",
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Color(0xFFC62828)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = rule.code,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    color = BrandPrimary
                                )
                                Text(
                                    text = rule.fullName,
                                    fontSize = 11.sp,
                                    color = TextSecondary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Tactical Panel Navigation Card with precise layout
 */
@Composable
private fun TacticalPanelCard(
    panelNumber: String,
    title: String,
    subtitle: String,
    icon: String,
    badgeText: String,
    accentColor: Color,
    tag: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag(tag),
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
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(accentColor.copy(alpha = 0.12f))
                            .border(1.dp, accentColor.copy(alpha = 0.4f), RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = icon, fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = panelNumber,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Black,
                                color = accentColor,
                                letterSpacing = 0.8.sp
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(accentColor.copy(alpha = 0.1f))
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = badgeText,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = accentColor
                                )
                            }
                        }
                        Text(
                            text = title,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Black,
                            color = TextPrimary
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(accentColor.copy(alpha = 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Buka Panel",
                        tint = accentColor,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = TextSecondary,
                lineHeight = 16.sp
            )
        }
    }
}

@Composable
fun DashboardMetricPill(
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF1B3826))
            .border(1.dp, Color(0xFF3B6B4C), RoundedCornerShape(8.dp))
            .padding(vertical = 10.dp, horizontal = 12.dp)
    ) {
        Column {
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Black,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFA5D6A7),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun EmergencyCodeBadge(
    code: String,
    label: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color.copy(alpha = 0.08f))
            .border(1.dp, color.copy(alpha = 0.35f), RoundedCornerShape(8.dp))
            .padding(vertical = 8.dp, horizontal = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = code,
                fontSize = 11.sp,
                fontWeight = FontWeight.Black,
                color = color
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = label,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = color,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
