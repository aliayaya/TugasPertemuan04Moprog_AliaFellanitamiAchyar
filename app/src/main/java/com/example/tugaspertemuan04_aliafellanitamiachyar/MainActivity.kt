package com.example.tugaspertemuan04_aliafellanitamiachyar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.screens.ProfileScreen
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.TugasPertemuan04_AliaFellanitamiAchyarTheme

/**
 * Main Activity for Tugas Pertemuan 04: Interactive Compose State Challenge
 * Mahasiswa: Alia Fellanitami Achyar (NIM: 0102523010 - Digit Akhir: 0)
 * Tema: Profil Mahasiswa / Biodata Interaktif
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasPertemuan04_AliaFellanitamiAchyarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}
