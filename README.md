# Tugas Pertemuan 04: Interactive Compose State Challenge
**Mata Kuliah:** Pemrograman Bergerak (3 SKS)  
**Program Studi:** Informatika, Fakultas Sains dan Teknologi, Universitas Al-Azhar Indonesia  
**Dosen Pengampu:** Dody, S.T., M.Kom.  

---

## Identitas Mahasiswa
- **Nama Lengkap:** Alia Fellanitami Achyar
- **NIM:** 0102523010
- **Digit Terakhir NIM:** `0`
- **Tema Aplikasi:** **Profil Mahasiswa / Biodata Interaktif** (Sesuai ketentuan rentang digit 0–1)
- **Repository Git:** [https://github.com/aliayaya/TugasPertemuan04_AliaFellanitamiAchyar](https://github.com/aliayaya/TugasPertemuan04_AliaFellanitamiAchyar)

---

## 1. Deskripsi Aplikasi
Aplikasi **Proma Compose (Profil Mahasiswa Interaktif)** adalah aplikasi Android berbasis **Jetpack Compose** dengan desain **Material 3**. Aplikasi ini mengimplementasikan interaktivitas state secara menyeluruh, mencakup penyimpanan state yang tahan rotasi layar (`rememberSaveable`), pemisahan state dan event (*State Hoisting*) pada komponen *stateless*, validasi form *real-time*, aksi tombol *Reset*, dan tampilan umpan balik (*Feedback Card*) saat biodata berhasil disimpan.

---

## 2. Fitur-Fitur Utama
1. **Material 3 Dark Slate & Muted Olive Theme:** Tampilan modern, elegan, dan konsisten dengan kontras warna yang nyaman bagi mata.
2. **Input Teks Interaktif (Minimal 2 Text Input):**
   - Nama Lengkap Mahasiswa (`name`)
   - Nomor Induk Mahasiswa (`nim`) — dibatasi 10 digit angka
   - Email Akademik (`email`) — verifikasi format `@` dan domain `.`
   - Bio Singkat / Minat Penelitian (`bio`) — multi-line input
3. **Numeric Stepper (State Numerik):**
   - Counter pemilihan **Semester Berjalan** (rentang semester 1 s/d 8) dengan tombol decrement (`-`) dan increment (`+`).
4. **Peminatan Selection Chips (State Selection):**
   - Filter Chips interaktif untuk memilih konsentrasi keahlian: *Rekayasa Perangkat Lunak*, *Kecerdasan Buatan*, *Keamanan Siber*, dan *Sains Data*.
5. **Switch Status Keaktifan (State Boolean Switch):**
   - Switch untuk mengubah status keaktifan kuliah antara *"Mahasiswa Aktif"* dan *"Non-Aktif / Cuti"*.
6. **Checkbox Pernyataan Keabsahan Data (State Boolean Checkbox):**
   - Checkbox persetujuan yang menjadi salah satu syarat validasi form.
7. **Validasi Form Real-time & Feedback:**
   - Evaluasi kelayakan input secara *real-time*:
     - Nama minimal 3 karakter.
     - NIM wajib tepat 10 digit numerik.
     - Email berformat valid.
     - Checkbox pernyataan wajib dicentang.
   - Tombol **"Simpan Biodata"** secara dinamis berstatus *disabled* selama syarat belum terpenuhi, dan otomatis menjadi *enabled* ketika form telah valid.
   - Dilengkapi kartu checklist panduan validasi visual.
8. **State Hoisting & Stateless Components:**
   - Seluruh komponen input (`StatelessInputField`, `SemesterStepper`, `PeminatanSelectionGroup`, `ActiveStatusSwitch`, `AgreementCheckbox`, `FormActionButtons`, `ProfileFeedbackCard`) bersifat *stateless* dan menerima nilai serta *callback* dari parent (`ProfileScreen`).
9. **State Persistence (`rememberSaveable`):**
   - Menggunakan `rememberSaveable` pada seluruh state form agar data tidak hilang ketika terjadi *configuration change* seperti rotasi layar (*screen rotation*).
10. **Fungsi Reset State:**
    - Tombol **"Reset"** mengembalikan seluruh state form ke nilai awal secara instan.

---

## 3. Tabel Pemetaan State
Sesuai dengan ketentuan Bagian 7 pada petunjuk tugas, berikut adalah tabel rincian state yang digunakan:

| Nama State | Tipe Data | Owner (Pemilik State) | Komponen yang Membaca / Mengubah | Keterangan & Tujuan |
|---|---|---|---|---|
| `name` | `String` | `ProfileScreen` | `StatelessInputField`, Validasi Form, `ProfileFeedbackCard` | Menyimpan input teks nama lengkap mahasiswa |
| `nim` | `String` | `ProfileScreen` | `StatelessInputField`, Validasi Form, `ProfileFeedbackCard` | Menyimpan 10 digit NIM mahasiswa |
| `email` | `String` | `ProfileScreen` | `StatelessInputField`, Validasi Form, `ProfileFeedbackCard` | Menyimpan alamat email akademik mahasiswa |
| `bio` | `String` | `ProfileScreen` | `StatelessInputField`, `ProfileFeedbackCard` | Menyimpan catatan profil atau minat penelitian |
| `semester` | `Int` | `ProfileScreen` | `SemesterStepper`, `ProfileFeedbackCard` | Menyimpan nilai numerik semester (1–8) |
| `selectedPeminatan` | `String` | `ProfileScreen` | `PeminatanSelectionGroup`, `ProfileFeedbackCard` | Menyimpan pilihan konsentrasi peminatan |
| `isMahasiswaAktif` | `Boolean` | `ProfileScreen` | `ActiveStatusSwitch`, `ProfileFeedbackCard` | Menyimpan status keaktifan (Aktif/Cuti) via Switch |
| `isAgreed` | `Boolean` | `ProfileScreen` | `AgreementCheckbox`, Validasi Form (`isFormValid`) | Menyimpan status persetujuan keabsahan data via Checkbox |
| `isSubmitted` | `Boolean` | `ProfileScreen` | `ProfileFeedbackCard` (Visibility), `FormActionButtons` | Menentukan kemunculan kartu feedback hasil simpan |

---

## 4. Struktur Direktori Proyek
```text
TugasPertemuan04_AliaFellanitamiAchyar/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/com/example/tugaspertemuan04_aliafellanitamiachyar/
│       │   │   ├── MainActivity.kt
│       │   │   ├── ui/
│       │   │   │   ├── components/
│       │   │   │   │   └── StatelessComponents.kt
│       │   │   │   ├── screens/
│       │   │   │   │   └── ProfileScreen.kt
│       │   │   │   └── theme/
│       │   │   │       ├── Color.kt
│       │   │   │       ├── Theme.kt
│       │   │   │       └── Type.kt
│       │   └── res/
├── gradle/
│   ├── libs.versions.toml
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## 5. Cara Menjalankan Proyek
1. Buka software **Android Studio** (Koala / Ladybug / Meerkat atau yang lebih baru).
2. Pilih menu **File > Open**, lalu arahkan ke folder `TugasPertemuan04_AliaFellanitamiAchyar`.
3. Tunggu hingga proses **Gradle Sync** selesai secara otomatis.
4. Pastikan perangkat emulator (misal Pixel 8 API 34/35) atau perangkat fisik Android yang terhubung sudah aktif.
5. Klik tombol **Run 'app'** (tombol hijau play) atau tekan shortcut `Shift + F10`.
6. Aplikasi akan ter-build dan langsung terbuka di emulator/perangkat.

---

## 6. Deklarasi Penggunaan AI
Dalam pengerjaan tugas ini, saya menggunakan AI generatif sebagai alat bantu.
- **Tools yang digunakan:** Google DeepMind / Antigravity Coding Assistant.
- **Bagian yang dibantu AI:**
  - Perancangan arsitektur pemisahan komponen *stateless* dan *stateful* (*State Hoisting*).
  - Pembentukan skema validasi form secara *reactive* menggunakan Compose.
  - Perapian struktur dokumentasi laporan dan README.
- **Pernyataan:** Saya menyatakan memahami seluruh kode yang saya kumpulkan dan bersedia menjelaskan atau memodifikasinya secara langsung pada sesi verifikasi/live modification.
