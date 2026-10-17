package com.example.data

import com.example.model.CrimeArticle
import com.example.model.CrimeChapter

object CrimeCodeData {

    val chapters: List<CrimeChapter> = listOf(
        CrimeChapter(
            roman = "I",
            title = "PENYERANGAN & PEMBUNUHAN",
            subtitle = "Tindak Kekerasan",
            articles = listOf(
                CrimeArticle("1.1", "🔹", "Percobaan penyerangan terhadap warga sipil", "Level 4", "Jika menggunakan senjata api → Lisensi dicabut", null, "I", "PENYERANGAN & PEMBUNUHAN", "Tindak Kekerasan"),
                CrimeArticle("1.2", "🔹", "Pembunuhan warga sipil", "Level 6", "Jika menggunakan senjata api → Lisensi dicabut", null, "I", "PENYERANGAN & PEMBUNUHAN", "Tindak Kekerasan"),
                CrimeArticle("1.3", "🔹", "Percobaan penyerangan terhadap pejabat", "Level 5", "Jika menggunakan senjata api → Lisensi dicabut", null, "I", "PENYERANGAN & PEMBUNUHAN", "Tindak Kekerasan"),
                CrimeArticle("1.4", "🔹", "Pembunuhan pejabat", "Level 6 – 7", "Jika menggunakan senjata api → Lisensi dicabut", null, "I", "PENYERANGAN & PEMBUNUHAN", "Tindak Kekerasan"),
                CrimeArticle("1.5", "🔹", "Penyerangan terhadap konvoi pemerintah", "Level 6", "Jika menggunakan senjata api → Lisensi dicabut", null, "I", "PENYERANGAN & PEMBUNUHAN", "Tindak Kekerasan"),
                CrimeArticle("1.6", "🔹", "Penyerangan dengan maksud mendapatkan keuntungan", "Level 5", null, null, "I", "PENYERANGAN & PEMBUNUHAN", "Tindak Kekerasan"),
                CrimeArticle("1.7", "🚗", "Tabrakan kendaraan dengan warga sipil", "Level 4", null, null, "I", "PENYERANGAN & PEMBUNUHAN", "Tindak Kekerasan"),
                CrimeArticle("1.8", "🚓", "Tabrakan kendaraan dengan pejabat", "Level 5", null, null, "I", "PENYERANGAN & PEMBUNUHAN", "Tindak Kekerasan")
            )
        ),
        CrimeChapter(
            roman = "II",
            title = "SUAP & KORUPSI",
            subtitle = "Tindak Pidana Korupsi",
            articles = listOf(
                CrimeArticle("2.1", "🔹", "Percobaan / upaya menyuap pejabat", "Level 3", null, null, "II", "SUAP & KORUPSI", "Tindak Pidana Korupsi"),
                CrimeArticle("2.2", "🔹", "Percobaan / upaya menyuap warga sipil", "Level 3", null, null, "II", "SUAP & KORUPSI", "Tindak Pidana Korupsi"),
                CrimeArticle("2.3", "🔹", "Penerimaan suap oleh pejabat", "Level 4", null, "200% dari jumlah suap", "II", "SUAP & KORUPSI", "Tindak Pidana Korupsi"),
                CrimeArticle("2.4", "🔹", "Korupsi dalam organisasi pemerintahan", "Level 6", null, "R$ 10.000", "II", "SUAP & KORUPSI", "Tindak Pidana Korupsi")
            )
        ),
        CrimeChapter(
            roman = "III",
            title = "SENJATA",
            subtitle = "Kepemilikan & Penggunaan Senjata",
            articles = listOf(
                CrimeArticle("3.1", "🔹", "Membawa senjata secara terbuka (kecuali pembelaan diri)", "Level 3", "Jika digunakan untuk penyerangan → Lisensi dicabut", null, "III", "SENJATA", "Kepemilikan & Penggunaan Senjata"),
                CrimeArticle("3.2", "🔹", "Membawa senjata tanpa lisensi", "Level 5", null, null, "III", "SENJATA", "Kepemilikan & Penggunaan Senjata"),
                CrimeArticle("3.3", "🔹", "Perdagangan senjata ilegal (beli / jual / tukar)", "Level 6", "Jika digunakan untuk penyerangan → Lisensi dicabut", null, "III", "SENJATA", "Kepemilikan & Penggunaan Senjata"),
                CrimeArticle("3.4", "🔹", "Melepaskan tembakan di tempat umum (kecuali pembelaan diri)", "Level 4", "Jika digunakan untuk penyerangan → Lisensi dicabut", null, "III", "SENJATA", "Kepemilikan & Penggunaan Senjata")
            )
        ),
        CrimeChapter(
            roman = "IV",
            title = "ZAT TERLARANG",
            subtitle = "Perdagangan & Penggunaan Zat Terlarang",
            articles = listOf(
                CrimeArticle("4.1", "🔹", "Perdagangan, transportasi, penyimpanan, penjualan, penanaman zat dill, tablet adrenalin, dan benih zat", "Level 6", "Diperbolehkan membawa hingga 5 zat terlarang dan hingga 5 benih", null, "IV", "ZAT TERLARANG", "Perdagangan & Penggunaan Zat Terlarang"),
                CrimeArticle("4.2", "🔹", "Penggunaan zat terlarang", "Level 2", null, null, "IV", "ZAT TERLARANG", "Perdagangan & Penggunaan Zat Terlarang"),
                CrimeArticle("4.3", "🔹", "Pembelian zat terlarang dan benih", "Level 4", null, null, "IV", "ZAT TERLARANG", "Perdagangan & Penggunaan Zat Terlarang"),
                CrimeArticle("4.4", "🔹", "Penanaman tanaman untuk diproses menjadi zat terlarang", "Level 6", null, null, "IV", "ZAT TERLARANG", "Perdagangan & Penggunaan Zat Terlarang")
            )
        ),
        CrimeChapter(
            roman = "V",
            title = "KELOMPOK KRIMINAL & EKSTREMISME",
            subtitle = "Tindak Pidana Kelompok & Ekstremisme",
            articles = listOf(
                CrimeArticle("5.1", "🔹", "Berada dalam kelompok kriminal (harus dibuktikan)", "Level 6", null, null, "V", "KELOMPOK KRIMINAL & EKSTREMISME", "Tindak Pidana Kelompok & Ekstremisme"),
                CrimeArticle("5.2", "🔹", "Merekrut anggota ke dalam kelompok kriminal", "Level 6", null, null, "V", "KELOMPOK KRIMINAL & EKSTREMISME", "Tindak Pidana Kelompok & Ekstremisme"),
                CrimeArticle("5.3", "🔹", "Seruan menuju ekstremisme", "Level 6", null, null, "V", "KELOMPOK KRIMINAL & EKSTREMISME", "Tindak Pidana Kelompok & Ekstremisme"),
                CrimeArticle("5.4", "🔹", "Berpartisipasi dalam kegiatan ekstremis", "Level 6", null, null, "V", "KELOMPOK KRIMINAL & EKSTREMISME", "Tindak Pidana Kelompok & Ekstremisme"),
                CrimeArticle("5.5", "🔹", "Merusak keamanan negara", "Level 6", null, null, "V", "KELOMPOK KRIMINAL & EKSTREMISME", "Tindak Pidana Kelompok & Ekstremisme")
            )
        ),
        CrimeChapter(
            roman = "VI",
            title = "TERORISME",
            subtitle = "Tindak Pidana Terorisme",
            articles = listOf(
                CrimeArticle("6.1", "🔹", "Melakukan atau merencanakan aksi teroris", "Level 6", null, null, "VI", "TERORISME", "Tindak Pidana Terorisme"),
                CrimeArticle("6.2", "🔹", "Penculikan, penahanan, penyekapan warga sipil", "Level 6", null, null, "VI", "TERORISME", "Tindak Pidana Terorisme"),
                CrimeArticle("6.3", "🔹", "Menjadi anggota kelompok teroris", "Level 6", null, null, "VI", "TERORISME", "Tindak Pidana Terorisme"),
                CrimeArticle("6.4", "🔹", "Pendanaan dan bantuan apapun untuk aksi teroris", "Level 6", null, null, "VI", "TERORISME", "Tindak Pidana Terorisme")
            )
        ),
        CrimeChapter(
            roman = "VII",
            title = "PENGKHIANATAN NEGARA & PENYALAHGUNAAN KEKUASAAN",
            subtitle = "Tindak Pidana Pengkhianatan & Kekuasaan",
            articles = listOf(
                CrimeArticle("7.1", "🔹", "Merencanakan atau melakukan tindakan pengkhianatan negara", "Level 6", null, null, "VII", "PENGKHIANATAN NEGARA & PENYALAHGUNAAN KEKUASAAN", "Tindak Pidana Pengkhianatan & Kekuasaan"),
                CrimeArticle("7.2", "🔹", "Bersekongkol atau mendanai pengkhianatan negara", "Level 6", null, null, "VII", "PENGKHIANATAN NEGARA & PENYALAHGUNAAN KEKUASAAN", "Tindak Pidana Pengkhianatan & Kekuasaan"),
                CrimeArticle("7.3", "🔹", "Kerja sama pegawai lembaga negara dengan organisasi ilegal/kriminal", "Level 6", null, null, "VII", "PENGKHIANATAN NEGARA & PENYALAHGUNAAN KEKUASAAN", "Tindak Pidana Pengkhianatan & Kekuasaan"),
                CrimeArticle("7.4", "🔹", "Pengungkapan rahasia negara", "Level 6", null, null, "VII", "PENGKHIANATAN NEGARA & PENYALAHGUNAAN KEKUASAAN", "Tindak Pidana Pengkhianatan & Kekuasaan"),
                CrimeArticle("7.5", "🔹", "Melampaui wewenang resmi demi keuntungan pribadi", "Level 4", null, null, "VII", "PENGKHIANATAN NEGARA & PENYALAHGUNAAN KEKUASAAN", "Tindak Pidana Pengkhianatan & Kekuasaan"),
                CrimeArticle("7.6", "🔹", "Kelalaian dalam melaksanakan tugas resmi", "Level 3", null, null, "VII", "PENGKHIANATAN NEGARA & PENYALAHGUNAAN KEKUASAAN", "Tindak Pidana Pengkhianatan & Kekuasaan")
            )
        ),
        CrimeChapter(
            roman = "VIII",
            title = "PERILAKU TIDAK PANTAS, PENGHINAAN & PERUSAKAN PROPERTI",
            subtitle = "Tindak Pidana Ringan & Perusakan",
            articles = listOf(
                CrimeArticle("8.1", "🔹", "Menghina warga sipil", "Level 1", null, null, "VIII", "PERILAKU TIDAK PANTAS, PENGHINAAN & PERUSAKAN PROPERTI", "Tindak Pidana Ringan & Perusakan"),
                CrimeArticle("8.2", "🔹", "Menghina pejabat yang sedang bertugas", "Level 2", null, null, "VIII", "PERILAKU TIDAK PANTAS, PENGHINAAN & PERUSAKAN PROPERTI", "Tindak Pidana Ringan & Perusakan"),
                CrimeArticle("8.3", "🔹", "Melakukan hooliganisme di tempat umum", "Level 2", null, null, "VIII", "PERILAKU TIDAK PANTAS, PENGHINAAN & PERUSAKAN PROPERTI", "Tindak Pidana Ringan & Perusakan"),
                CrimeArticle("8.4", "🔹", "Merusak properti negara", "Level 3", null, "R$ 5.000", "VIII", "PERILAKU TIDAK PANTAS, PENGHINAAN & PERUSAKAN PROPERTI", "Tindak Pidana Ringan & Perusakan"),
                CrimeArticle("8.5", "🔹", "Merusak properti warga sipil", "Level 2", null, "R$ 15.000", "VIII", "PERILAKU TIDAK PANTAS, PENGHINAAN & PERUSAKAN PROPERTI", "Tindak Pidana Ringan & Perusakan")
            )
        ),
        CrimeChapter(
            roman = "IX",
            title = "PENCURIAN",
            subtitle = "Tindak Pidana Pencurian",
            articles = listOf(
                CrimeArticle("9.1", "🔹", "Pencurian properti sipil", "Level 3", null, null, "IX", "PENCURIAN", "Tindak Pidana Pencurian"),
                CrimeArticle("9.2", "🔹", "Pencurian properti negara", "Level 4", null, null, "IX", "PENCURIAN", "Tindak Pidana Pencurian"),
                CrimeArticle("9.3", "🔹", "Percobaan / pencurian kendaraan sipil", "Level 5", null, null, "IX", "PENCURIAN", "Tindak Pidana Pencurian"),
                CrimeArticle("9.4", "🔹", "Percobaan / pencurian kendaraan negara", "Level 6", null, null, "IX", "PENCURIAN", "Tindak Pidana Pencurian"),
                CrimeArticle("9.5", "🔹", "Pemerasan uang atau barang berharga", "Level 4", null, null, "IX", "PENCURIAN", "Tindak Pidana Pencurian"),
                CrimeArticle("9.6", "🔹", "Penipuan dalam bentuk apapun", "Level 3", null, null, "IX", "PENCURIAN", "Tindak Pidana Pencurian")
            )
        ),
        CrimeChapter(
            roman = "X",
            title = "ANCAMAN",
            subtitle = "Tindak Pidana Ancaman",
            articles = listOf(
                CrimeArticle("10.1", "🔹", "Ancaman membunuh seseorang", "Level 4", null, null, "X", "ANCAMAN", "Tindak Pidana Ancaman"),
                CrimeArticle("10.2", "🔹", "Ancaman untuk memperoleh uang / barang / informasi", "Level 3", null, null, "X", "ANCAMAN", "Tindak Pidana Ancaman"),
                CrimeArticle("10.3", "🔹", "Ancaman terhadap keamanan negara", "Level 6", null, null, "X", "ANCAMAN", "Tindak Pidana Ancaman"),
                CrimeArticle("10.4", "🔹", "Ancaman terhadap lembaga penegak hukum", "Level 4", null, null, "X", "ANCAMAN", "Tindak Pidana Ancaman"),
                CrimeArticle("10.5", "🔹", "Tekanan fisik / memaksa pejabat untuk keuntungan pribadi atau merugikan warga & keamanan negara", "Level 6", null, null, "X", "ANCAMAN", "Tindak Pidana Ancaman")
            )
        ),
        CrimeChapter(
            roman = "XI",
            title = "RASISME, NAZISME & AGAMA",
            subtitle = "Tindak Pidana Diskriminasi & Penodaan",
            articles = listOf(
                CrimeArticle("11.1", "🔹", "Setiap bentuk rasisme", "Level 3", null, null, "XI", "RASISME, NAZISME & AGAMA", "Tindak Pidana Diskriminasi & Penodaan"),
                CrimeArticle("11.2", "🔹", "Mengorganisir pelecehan berdasarkan ras & penyebarannya", "Level 5", null, null, "XI", "RASISME, NAZISME & AGAMA", "Tindak Pidana Diskriminasi & Penodaan"),
                CrimeArticle("11.3", "🔹", "Setiap bentuk nazisme untuk menghina bangsa lain", "Level 3", null, null, "XI", "RASISME, NAZISME & AGAMA", "Tindak Pidana Diskriminasi & Penodaan"),
                CrimeArticle("11.4", "🔹", "Mengorganisir & menyebarkan nazisme", "Level 6", null, null, "XI", "RASISME, NAZISME & AGAMA", "Tindak Pidana Diskriminasi & Penodaan"),
                CrimeArticle("11.5", "🔹", "Menodai keyakinan seseorang", "Level 3", null, null, "XI", "RASISME, NAZISME & AGAMA", "Tindak Pidana Diskriminasi & Penodaan"),
                CrimeArticle("11.6", "🔹", "Mengorganisir penyerangan terhadap keyakinan agama sekelompok orang", "Level 5", null, null, "XI", "RASISME, NAZISME & AGAMA", "Tindak Pidana Diskriminasi & Penodaan")
            )
        ),
        CrimeChapter(
            roman = "XII",
            title = "PERKOSAAN",
            subtitle = "Tindak Pidana Perkosaan",
            articles = listOf(
                CrimeArticle("12.1", "🔹", "Perkosaan", "Level 4", null, null, "XII", "PERKOSAAN", "Tindak Pidana Perkosaan"),
                CrimeArticle("12.2", "🔹", "Perkosaan dengan kekejaman atau penghinaan khusus", "Level 5", null, null, "XII", "PERKOSAAN", "Tindak Pidana Perkosaan"),
                CrimeArticle("12.3", "🔹", "Perkosaan diikuti pembunuhan", "Level 6", null, null, "XII", "PERKOSAAN", "Tindak Pidana Perkosaan")
            )
        ),
        CrimeChapter(
            roman = "XIII",
            title = "WILAYAH TERLINDUNGI & DESERSI",
            subtitle = "Pelanggaran Wilayah & Unit Militer",
            articles = listOf(
                CrimeArticle("13.1", "🔹", "Berada di wilayah terlindungi tanpa izin", "Level 5", "Wilayah terlindungi: unit militer, penjara, area parkir kantor polisi, ruang kantor internal kantor polisi. Warga harus diberi tahu untuk meninggalkan tempat dalam 30 detik sebelum ditetapkan buronan", null, "XIII", "WILAYAH TERLINDUNGI & DESERSI", "Pelanggaran Wilayah & Unit Militer"),
                CrimeArticle("13.2", "🔹", "Desersi dari unit militer", "Level 4", null, null, "XIII", "WILAYAH TERLINDUNGI & DESERSI", "Pelanggaran Wilayah & Unit Militer"),
                CrimeArticle("13.3", "🔹", "Menyusup ke unit militer", "Level 2", null, null, "XIII", "WILAYAH TERLINDUNGI & DESERSI", "Pelanggaran Wilayah & Unit Militer"),
                CrimeArticle("13.4", "🔹", "Memasuki wilayah yang diblokir saat keadaan darurat", "Level 3", null, null, "XIII", "WILAYAH TERLINDUNGI & DESERSI", "Pelanggaran Wilayah & Unit Militer")
            )
        ),
        CrimeChapter(
            roman = "XIV",
            title = "MENGGANGGU LAYANAN PEMERINTAH",
            subtitle = "Tindak Pidana Mengganggu Pemerintah",
            articles = listOf(
                CrimeArticle("14.1", "🔹", "Mengganggu pekerjaan karyawan Kementerian Pertahanan & Polisi", "Level 3", null, null, "XIV", "MENGGANGGU LAYANAN PEMERINTAH", "Tindak Pidana Mengganggu Pemerintah"),
                CrimeArticle("14.2", "🔹", "Menguntit karyawan Kementerian Pertahanan & Polisi", "Level 4", null, null, "XIV", "MENGGANGGU LAYANAN PEMERINTAH", "Tindak Pidana Mengganggu Pemerintah"),
                CrimeArticle("14.3", "🔹", "Menciptakan hambatan bagi transportasi pemerintah", "Level 4", null, null, "XIV", "MENGGANGGU LAYANAN PEMERINTAH", "Tindak Pidana Mengganggu Pemerintah")
            )
        ),
        CrimeChapter(
            roman = "XV",
            title = "KETERLIBATAN",
            subtitle = "Pelibatan dalam Tindak Pidana",
            articles = listOf(
                CrimeArticle("15.1", "🔹", "Keterlibatan dalam tindak pidana", "Sama dengan pelaku utama", null, null, "XV", "KETERLIBATAN", "Pelibatan dalam Tindak Pidana"),
                CrimeArticle("15.2", "🔹", "Keterlibatan dalam pelarian dari Penjara Federal", "Level 4", null, null, "XV", "KETERLIBATAN", "Pelibatan dalam Tindak Pidana")
            )
        ),
        CrimeChapter(
            roman = "XVI",
            title = "UNJUK RASA",
            subtitle = "Tindak Pidana Unjuk Rasa",
            articles = listOf(
                CrimeArticle("16.1", "🔹", "Mengorganisir unjuk rasa tanpa izin", "Level 5", null, null, "XVI", "UNJUK RASA", "Tindak Pidana Unjuk Rasa"),
                CrimeArticle("16.2", "🔹", "Berpartisipasi dalam unjuk rasa tanpa izin", "Level 3", null, null, "XVI", "UNJUK RASA", "Tindak Pidana Unjuk Rasa"),
                CrimeArticle("16.3", "🔹", "Seruan kekerasan selama unjuk rasa", "Level 6", null, null, "XVI", "UNJUK RASA", "Tindak Pidana Unjuk Rasa"),
                CrimeArticle("16.4", "🔹", "Tindakan vandalisme selama unjuk rasa", "Level 6", null, null, "XVI", "UNJUK RASA", "Tindak Pidana Unjuk Rasa")
            )
        ),
        CrimeChapter(
            roman = "XVII",
            title = "TEMPAT UMUM",
            subtitle = "Penggunaan Balaclava",
            articles = listOf(
                CrimeArticle("17.1", "🔹", "Memakai balaclava di tempat umum", "Level 2", "Pertama kali: peringatan", null, "XVII", "TEMPAT UMUM", "Penggunaan Balaclava")
            )
        ),
        CrimeChapter(
            roman = "XVIII",
            title = "MENYAMAR SEBAGAI PEJABAT PEMERINTAH",
            subtitle = "Penyamaran",
            articles = listOf(
                CrimeArticle("18.1", "🔹", "Menyamar sebagai pejabat (memakai seragam)", "Level 3", null, null, "XVIII", "MENYAMAR SEBAGAI PEJABAT PEMERINTAH", "Penyamaran")
            )
        ),
        CrimeChapter(
            roman = "XIX",
            title = "PANGGILAN",
            subtitle = "Panggilan Palsu",
            articles = listOf(
                CrimeArticle("19.1", "🔹", "Panggilan palsu berulang", "Level 2", null, null, "XIX", "PANGGILAN", "Panggilan Palsu"),
                CrimeArticle("19.2", "🔹", "Panggilan palsu melalui tombol merah", "Level 3", null, null, "XIX", "PANGGILAN", "Panggilan Palsu"),
                CrimeArticle("19.3", "🔹", "Panggilan dengan penghinaan atau mendiskreditkan kerja lembaga penegak hukum", "Level 3", null, null, "XIX", "PANGGILAN", "Panggilan Palsu")
            )
        ),
        CrimeChapter(
            roman = "XX",
            title = "KETIDAKPATUHAN",
            subtitle = "Tidak Mematuhi Polisi",
            articles = listOf(
                CrimeArticle("20.1", "🔹", "Tidak mematuhi petugas polisi", "Level 3", null, null, "XX", "KETIDAKPATUHAN", "Tidak Mematuhi Polisi"),
                CrimeArticle("20.2", "🔹", "Tidak mematuhi petugas polisi selama keadaan darurat", "Level 4", null, null, "XX", "KETIDAKPATUHAN", "Tidak Mematuhi Polisi"),
                CrimeArticle("20.3", "🔹", "Menolak memberikan dokumen", "Level 2", null, null, "XX", "KETIDAKPATUHAN", "Tidak Mematuhi Polisi"),
                CrimeArticle("20.4", "🔹", "Mencoba melarikan diri dari petugas polisi", "Level 3", null, null, "XX", "KETIDAKPATUHAN", "Tidak Mematuhi Polisi")
            )
        ),
        CrimeChapter(
            roman = "XXI",
            title = "BARANG ILEGAL",
            subtitle = "Kepemilikan Barang Terlarang",
            articles = listOf(
                CrimeArticle("21.1", "🔹", "Kepemilikan barang untuk pembebasan dari Penjara Federal", "Level 5", null, null, "XXI", "BARANG ILEGAL", "Kepemilikan Barang Terlarang"),
                CrimeArticle("21.2", "🔹", "Kepemilikan kunci palsu untuk membobol kendaraan dengan tujuan pencurian & penjualan", "Level 5", null, null, "XXI", "BARANG ILEGAL", "Kepemilikan Barang Terlarang")
            )
        )
    )

    val allArticles: List<CrimeArticle> = chapters.flatMap { it.articles }

    data class StarGroupInfo(
        val starRating: Int,
        val starText: String,
        val title: String,
        val subtitle: String,
        val colorHex: Long,
        val protocol: String
    )

    val starTierDefinitions = listOf(
        StarGroupInfo(
            starRating = 6,
            starText = "★★★★★★",
            title = "BINTANG 6 : KRIMINALITAS KRITIS",
            subtitle = "Pembunuhan Sipil/Pejabat, Terorisme, Makar & Sindikat (Level 6 – 7)",
            colorHex = 0xFFD32F2F,
            protocol = "Otorisasi unit penindak bersenjata, pembatalan izin senjata, penahanan federal."
        ),
        StarGroupInfo(
            starRating = 5,
            starText = "★★★★★",
            title = "BINTANG 5 : KRIMINAL BERAT",
            subtitle = "Penyerangan Aparat, Senjata Ilegal, Pencurian Ranmor (Level 5)",
            colorHex = 0xFFE65100,
            protocol = "Pengawalan bersenjata, penahanan isolasi, koordinasi penuntutan pidana."
        ),
        StarGroupInfo(
            starRating = 4,
            starText = "★★★★",
            title = "BINTANG 4 : PELANGGARAN MAYOR",
            subtitle = "Penyerangan Sipil, Pemerasan, Tabrakan, Desersi (Level 4)",
            colorHex = 0xFFF57F17,
            protocol = "Penahanan kurungan, pengamanan barang bukti, sidang penuntutan."
        ),
        StarGroupInfo(
            starRating = 3,
            starText = "★★★",
            title = "BINTANG 3 : TINDAK PIDANA SEDANG",
            subtitle = "Senjata Terbuka, Pencurian Properti, Melarikan Diri (Level 3)",
            colorHex = 0xFF1976D2,
            protocol = "Pemeriksaan resmi, tilang administratif, penahanan sementara jika melawan."
        ),
        StarGroupInfo(
            starRating = 2,
            starText = "★★",
            title = "BINTANG 2 : KETERTIBAN UMUM & ZAT",
            subtitle = "Hooliganisme, Balaclava, Penghinaan Petugas, Zat Ringan (Level 2)",
            colorHex = 0xFF00897B,
            protocol = "Pemberian denda tilang di tempat, penyitaan barang terlarang, catatan peringatan."
        ),
        StarGroupInfo(
            starRating = 1,
            starText = "★",
            title = "BINTANG 1 : PELANGGARAN RINGAN",
            subtitle = "Penghinaan Warga Sipil & Etika Publik (Level 1)",
            colorHex = 0xFF2E7D32,
            protocol = "Mediasi atau teguran lisan resmi, denda ganti rugi ringan."
        ),
        StarGroupInfo(
            starRating = 0,
            starText = "⚡",
            title = "TINGKAT KHUSUS : KETERLIBATAN",
            subtitle = "Penyertaan & Membantu Tindak Pidana",
            colorHex = 0xFF7B1FA2,
            protocol = "Dikenakan sanksi setara dengan pelaku utama yang dibantu."
        )
    )
}
