package com.example.data

import com.example.model.EmsCommonCrime
import com.example.model.EmsMelamunStep
import com.example.model.EmsRestrictedArea
import com.example.model.EmsWarningStep
import com.example.model.UupRule

object EmsSopData {

    // 1. KETENTUAN PERSONIL
    const val MIN_PERSONNEL = 3
    const val MAX_PERSONNEL = 4
    const val PERSONNEL_RULE = "PENJAGAAN EMS WAJIB DIISI 3 PERSONIL, MAKSIMAL 4 PERSONIL"

    // 2. PENJAGAAN AREA TERLARANG EMS
    val restrictedAreas = listOf(
        EmsRestrictedArea(
            id = "ruang_obat",
            name = "Ruang Obat",
            icon = "💊",
            note = "Dilarang keras dimasuki tanpa izin dokter / kepala divisi obat"
        ),
        EmsRestrictedArea(
            id = "ruang_wadir",
            name = "Ruang Wakil Direktur",
            icon = "💼",
            note = "Area privat pimpinan rumah sakit dan koordinasi internal EMS"
        ),
        EmsRestrictedArea(
            id = "ruang_ganti",
            name = "Ruang Ganti Pakaian",
            icon = "👔",
            note = "Area loker steril khusus personil medis berseragam resmi"
        )
    )

    // 3. SOP MEMPERINGATKAN WARGA
    val warningSteps = listOf(
        EmsWarningStep(
            stepNumber = 1,
            title = "BERI ISYARAT",
            description = "Beri isyarat visual / gerakan tangan secara tegas ke arah warga",
            badge = "3x",
            icon = "✋"
        ),
        EmsWarningStep(
            stepNumber = 2,
            title = "BERI VOIP",
            description = "Gunakan komunikasi suara mikrofon/VOIP memperingatkan warga untuk menjauh",
            badge = "3x",
            icon = "🗣️"
        ),
        EmsWarningStep(
            stepNumber = 3,
            title = "JIKA MASIH BEBAL",
            description = "Tidak mematuhi perintah? Silahkan tindak lanjuti sesuai dengan pasal hukum",
            badge = "TINDAK",
            icon = "⚖️"
        )
    )

    // 4. KODE KRIMINAL / PASAL YANG SERING TERJADI DI EMS
    val commonCrimes = listOf(
        EmsCommonCrime(
            articleId = "8.2",
            icon = "😡",
            violation = "Menghina petugas EMS/Kepolisian",
            levelCode = "B2",
            stars = 2
        ),
        EmsCommonCrime(
            articleId = "11.1",
            icon = "👥",
            violation = "Rasisme",
            levelCode = "B3",
            stars = 3
        ),
        EmsCommonCrime(
            articleId = "12.1",
            icon = "👥",
            violation = "Perkosaan / Pelecehan",
            levelCode = "B4",
            stars = 4
        ),
        EmsCommonCrime(
            articleId = "13.1",
            icon = "🚪🚫",
            violation = "Memasuki Ruangan Terlindung tanpa izin",
            levelCode = "B5",
            stars = 5
        ),
        EmsCommonCrime(
            articleId = "14.1",
            icon = "🏃💥",
            violation = "Mengganggu Petugas",
            levelCode = "B3",
            stars = 3
        ),
        EmsCommonCrime(
            articleId = "14.2",
            icon = "🚶‍♂️🚶‍♀️",
            violation = "Menguntit / Membuntuti Petugas EMS/Kepolisian",
            levelCode = "B4",
            stars = 4
        ),
        EmsCommonCrime(
            articleId = "20.1",
            icon = "✋",
            violation = "Tidak mematuhi petugas",
            levelCode = "B3",
            stars = 3
        )
    )

    // 5. SOP MENGHADAPI WARGA LOKAL YANG MELAMUN
    val melamunSteps = listOf(
        EmsMelamunStep(
            stepNumber = 1,
            title = "BERI PERINGATAN ISYARAT 3x",
            description = "Lambaikan tangan di depan karakter dengan tenggat waktu.",
            tag = "DURASI 10 DETIK",
            isWarning = false
        ),
        EmsMelamunStep(
            stepNumber = 2,
            title = "BERI VOIP 2x",
            description = "Panggil karakter melalui audio VOIP dengan jelas sebanyak 2 kali.",
            tag = "VOIP 2x",
            isWarning = false
        ),
        EmsMelamunStep(
            stepNumber = 3,
            title = "JIKA MASIH DIAM",
            description = "Warga tidak merespons atau tetap melamun/AFK di area rumah sakit.",
            tag = "TINDAK LANJUT SESUAI SOP",
            isWarning = true
        ),
        EmsMelamunStep(
            stepNumber = 4,
            title = "SERET KELUAR & KENAKAN PASAL",
            description = "Seret keluar area EMS & kenakan Pasal 14.1 Mengganggu Petugas (B3). *Bagi yang tidak memiliki bercak darah.",
            tag = "PASAL 14.1 (B3)",
            isWarning = true
        ),
        EmsMelamunStep(
            stepNumber = 5,
            title = "SETELAH DISERET KELUAR",
            description = "Setelah warga berhasil dipindahkan keluar area RS, hapus kembali status bintang / pencarian.",
            tag = "HAPUS BINTANG / BERSIH",
            isSuccess = true
        )
    )

    // 6. UUD / UUP KEPOLISIAN KOTA 5 RIORISE (Undang-Undang Peraturan Roleplay)
    val uupRules = listOf(
        UupRule("MDM", "Mass Death Match", "UUP INHUMANE", "Dilarang membunuh lebih dari 2 orang dengan alasan yang tidak sah atau tanpa berdialog.", 60, "💀"),
        UupRule("RDM", "Random Death Match", "UUP WILD", "Ikut campur dengan RP yang sudah diatur / membunuh tanpa ada interaksi dialog.", 60, "💀"),
        UupRule("VDM", "Vehicle Death Match", "UUP INHUMANE", "Dengan sengaja membunuh atau melukai orang menggunakan kendaraan.", 60, "🚗"),
        UupRule("MG", "Metagaming", "UUP OUT OF GAME", "Membawa informasi dari luar permainan untuk keuntungan atau merugikan pemain lain.", 60, "🧠"),
        UupRule("CL", "Combat Log", "UUP OUT GAME", "Meninggalkan permainan saat beraksi (hindari penculikan, penangkapan, pembunuhan).", 60, "🚪"),
        UupRule("DM", "Death Match", "UUP INHUMANE", "Membunuh atau merusak perlindungan (vest) seseorang tanpa alasan/berdialog.", 60, "💀"),
        UupRule("RK", "Revenge Kill", "UUP FEUD", "Membunuh dengan tujuan balas dendam karena kejadian sebelumnya dimana anda dibunuh.", 60, "⚔️"),
        UupRule("SK", "Spawn Kill", "UUP KILLING THE WEAK", "Membunuh atau merusak perlindungan di tempat spawn tanpa alasan yang jelas.", 60, "🎯"),
        UupRule("TK", "Team Kill", "UUP TWOFACE", "Membunuh teman sendiri atau merusak perlindungan di dalam satu fraksi.", 40, "👥"),
        UupRule("SAAV", "Semi Amor A Vida", "UUP NOT CARE", "Lebih memilih mati ketimbang menjalankan alur skenario roleplay yang realistis.", 60, "🛡️"),
        UupRule("PG", "Power Gaming", "UUP ABNORMAL", "Melakukan tindakan di luar batas manusia normal seperti melompati ketinggian ekstrim.", 60, "💪"),
        UupRule("FLAMING", "Flaming RP / Drak RP", "UUP HATE SPEECH", "Melakukan rasisme, pelecehan seksual, mencaci maki di luar batas etika RP.", 60, "🔥"),
        UupRule("IFP", "Informasi Dalam Karakter", "UUP SUPERNATURAL", "Mengetahui nama/status seseorang tanpa berkenalan atau interaksi terlebih dahulu.", 60, "ℹ️"),
        UupRule("ZZ", "Zig Zag", "UUP ZIGZAG", "Berlari dan berjalan menggunakan metode ke kanan-kiri dalam 1 detik untuk hindari peluru.", 40, "⚡"),
        UupRule("KOS", "Kill On Sight", "UUP KILLING MEMBERS", "Membunuh seseorang dari fraksi pemerintah di tempat tanpa alasan yang jelas.", 60, "👑"),
        UupRule("PK", "Player Kill", "UUP AMNESIA", "Ketika koma/terbunuh harus melupakan kejadian sampai tanda masalah koma clear.", 60, "🩹"),
        UupRule("RPFW", "Roleplay For The Win", "UUP SON OF GOD", "Hanya ingin menang dengan cheat, bug, atau menolak kalah secara realistis.", 60, "🏆"),
        UupRule("MIXING", "Mencampur Aduk", "UUP NOT REAL", "Mencampuradukkan kehidupan nyata dengan obrolan RP dan membahas game lain.", 60, "🔄"),
        UupRule("AAP", "Tindakan Sewenang-wenang", "UUP ANNOYING", "Mengganggu orang yang sedang berdiskusi, dialog, dan berinteraksi.", 60, "😤"),
        UupRule("DMA", "Death Match Auto", "UUP DAMAGING VEHICLES", "Merusak fasilitas/kendaraan seseorang tanpa alasan yang jelas.", 60, "🚗💥"),
        UupRule("NRA", "Non Roleplay Ambient", "UUP CARRYING WEAPON", "Memegang senjata di tempat fraksi atau green zone selama 3 menit.", 20, "🔫"),
        UupRule("NDR", "Non Drive RP", "UUP RECKLESS DRIVING", "Mengemudi asal-asalan, dalam keadaan mabuk atau menabrak tanpa RP jelas.", 60, "🏎️"),
        UupRule("AI", "Irregular Action", "UUP ATTACKING RESIDENCE", "Menyerbu/menyerang kediaman seseorang (mansion/hood) untuk kesenangan semata.", 60, "🏠"),
        UupRule("INA", "Unauthorized Invasion", "UUP ATTACKING FRACTION", "Menyerbu atau menyerang markas fraksi lain tanpa izin resmi.", 60, "🛡️"),
        UupRule("FAIL", "Tindakan Gagal", "UUP FAILED", "Melakukan tindakan di luar peraturan fraksi / organisasi / wilayah hood.", 60, "⚠️"),
        UupRule("TSC", "Smuggled Goods", "UUP SMUGGLING", "Memindahkan barang ke pemain lain tanpa persetujuan sah dari pemiliknya.", 20, "📦")
    )
}
