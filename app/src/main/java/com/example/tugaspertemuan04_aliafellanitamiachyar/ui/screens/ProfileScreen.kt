package com.example.tugaspertemuan04_aliafellanitamiachyar.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.components.ActiveStatusSwitch
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.components.AgreementCheckbox
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.components.FormActionButtons
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.components.PeminatanSelectionGroup
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.components.ProfileFeedbackCard
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.components.SemesterStepper
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.components.StatelessHeader
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.components.StatelessInputField
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.DarkBackground
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.DarkBorder
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.DarkSurface
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.ErrorRed
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.InfoBlue
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.SuccessGreen
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.TextMuted
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.TextPrimary
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.TextSecondary

/**
 * Stateful Composable Screen for Student Profile & Biodata Form
 * Owns all state using rememberSaveable and hoists state into child components.
 */
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    // 1. Form States (using rememberSaveable to persist across configuration / orientation changes)
    var name by rememberSaveable { mutableStateOf("") }
    var nim by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var bio by rememberSaveable { mutableStateOf("") }
    var semester by rememberSaveable { mutableIntStateOf(5) }
    var selectedPeminatan by rememberSaveable { mutableStateOf("Rekayasa Perangkat Lunak") }
    var isMahasiswaAktif by rememberSaveable { mutableStateOf(true) }
    var isAgreed by rememberSaveable { mutableStateOf(false) }
    var isSubmitted by rememberSaveable { mutableStateOf(false) }

    // Snapshot of submitted profile data
    var savedName by rememberSaveable { mutableStateOf("") }
    var savedNim by rememberSaveable { mutableStateOf("") }
    var savedEmail by rememberSaveable { mutableStateOf("") }
    var savedBio by rememberSaveable { mutableStateOf("") }
    var savedSemester by rememberSaveable { mutableIntStateOf(5) }
    var savedPeminatan by rememberSaveable { mutableStateOf("") }
    var savedStatus by rememberSaveable { mutableStateOf(true) }

    // Peminatan Options list
    val peminatanOptions = listOf(
        "Rekayasa Perangkat Lunak",
        "Kecerdasan Buatan",
        "Keamanan Siber",
        "Sains Data"
    )

    // 2. Real-time Form Validation Logic
    val isNameValid = name.trim().length >= 3
    val isNimValid = nim.trim().length == 10 && nim.trim().all { it.isDigit() }
    val isEmailValid = email.trim().contains("@") && email.trim().contains(".") && email.trim().length >= 6
    val isFormValid = isNameValid && isNimValid && isEmailValid && isAgreed

    // Error messages
    val nameErrorMsg = when {
        name.isEmpty() -> null
        name.trim().length < 3 -> "Nama minimal 3 karakter"
        else -> null
    }

    val nimErrorMsg = when {
        nim.isEmpty() -> null
        nim.length != 10 -> "NIM harus tepat 10 digit (contoh: 0102523010)"
        !nim.all { it.isDigit() } -> "NIM hanya boleh berisi angka"
        else -> null
    }

    val emailErrorMsg = when {
        email.isEmpty() -> null
        !email.contains("@") || !email.contains(".") || email.length < 6 -> "Format email tidak valid (contoh: nama@student.uai.ac.id)"
        else -> null
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = DarkBackground
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            // Header Bar
            StatelessHeader(
                appName = "Proma Compose",
                subtitle = "Biodata & Profil Mahasiswa (Interactive State)"
            )

            // Section 1: Identitas Mahasiswa (Text Inputs)
            SectionCard(title = "1. Data Identitas Mahasiswa") {
                StatelessInputField(
                    value = name,
                    onValueChange = {
                        name = it
                        isSubmitted = false
                    },
                    label = "Nama Lengkap Mahasiswa",
                    placeholder = "Misal: Alia Fellanitami Achyar",
                    leadingIcon = Icons.Default.Person,
                    isError = name.isNotEmpty() && !isNameValid,
                    errorMessage = nameErrorMsg
                )

                StatelessInputField(
                    value = nim,
                    onValueChange = {
                        if (it.length <= 10 && (it.isEmpty() || it.all { char -> char.isDigit() })) {
                            nim = it
                            isSubmitted = false
                        }
                    },
                    label = "Nomor Induk Mahasiswa (NIM)",
                    placeholder = "10 Digit (Misal: 0102523010)",
                    leadingIcon = Icons.Default.Badge,
                    isError = nim.isNotEmpty() && !isNimValid,
                    errorMessage = nimErrorMsg
                )

                StatelessInputField(
                    value = email,
                    onValueChange = {
                        email = it
                        isSubmitted = false
                    },
                    label = "Email Akademik Mahasiswa",
                    placeholder = "Misal: alia.achyar@student.uai.ac.id",
                    leadingIcon = Icons.Default.Email,
                    isError = email.isNotEmpty() && !isEmailValid,
                    errorMessage = emailErrorMsg
                )

                StatelessInputField(
                    value = bio,
                    onValueChange = {
                        bio = it
                        isSubmitted = false
                    },
                    label = "Bio Singkat / Minat Penelitian",
                    placeholder = "Catatan singkat minat atau tujuan akademik...",
                    leadingIcon = Icons.Default.Description,
                    singleLine = false,
                    maxLines = 3
                )
            }

            // Section 2: Informasi Akademik (Numeric Stepper & Selection Chips)
            SectionCard(title = "2. Informasi Akademik & Peminatan") {
                SemesterStepper(
                    semester = semester,
                    onIncrement = {
                        if (semester < 8) {
                            semester++
                            isSubmitted = false
                        }
                    },
                    onDecrement = {
                        if (semester > 1) {
                            semester--
                            isSubmitted = false
                        }
                    }
                )

                Spacer(modifier = Modifier.height(4.dp))

                PeminatanSelectionGroup(
                    selectedPeminatan = selectedPeminatan,
                    options = peminatanOptions,
                    onSelectionChange = {
                        selectedPeminatan = it
                        isSubmitted = false
                    }
                )
            }

            // Section 3: Status & Persetujuan (Switch & Checkbox)
            SectionCard(title = "3. Status Keaktifan & Persetujuan Data") {
                ActiveStatusSwitch(
                    isActive = isMahasiswaAktif,
                    onActiveChange = {
                        isMahasiswaAktif = it
                        isSubmitted = false
                    }
                )

                Spacer(modifier = Modifier.height(2.dp))

                AgreementCheckbox(
                    isAgreed = isAgreed,
                    onAgreedChange = {
                        isAgreed = it
                        isSubmitted = false
                    }
                )
            }

            // Section 4: Live Validation Checklist Card
            ValidationChecklistCard(
                isNameValid = isNameValid,
                isNimValid = isNimValid,
                isEmailValid = isEmailValid,
                isAgreed = isAgreed
            )

            // Section 5: Action Buttons (Reset & Simpan Profil)
            FormActionButtons(
                isFormValid = isFormValid,
                onSave = {
                    if (isFormValid) {
                        savedName = name
                        savedNim = nim
                        savedEmail = email
                        savedBio = bio
                        savedSemester = semester
                        savedPeminatan = selectedPeminatan
                        savedStatus = isMahasiswaAktif
                        isSubmitted = true
                    }
                },
                onReset = {
                    // Reset all form state to initial values
                    name = ""
                    nim = ""
                    email = ""
                    bio = ""
                    semester = 5
                    selectedPeminatan = "Rekayasa Perangkat Lunak"
                    isMahasiswaAktif = true
                    isAgreed = false
                    isSubmitted = false
                }
            )

            // Section 6: Profile Feedback Card (Animated visibility upon submission)
            AnimatedVisibility(
                visible = isSubmitted,
                enter = fadeIn() + slideInVertically(initialOffsetY = { 20 }),
                exit = fadeOut()
            ) {
                ProfileFeedbackCard(
                    name = savedName,
                    nim = savedNim,
                    email = savedEmail,
                    bio = savedBio,
                    semester = savedSemester,
                    peminatan = savedPeminatan,
                    isActive = savedStatus
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

/**
 * Reusable Card container for Form Sections
 */
@Composable
private fun SectionCard(
    title: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = DarkSurface),
        border = androidx.compose.foundation.BorderStroke(1.dp, DarkBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = TextPrimary,
                fontWeight = FontWeight.Bold
            )
            content()
        }
    }
}

/**
 * Visual validation checklist showing user the exact status of each requirement
 */
@Composable
private fun ValidationChecklistCard(
    isNameValid: Boolean,
    isNimValid: Boolean,
    isEmailValid: Boolean,
    isAgreed: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = DarkSurface.copy(alpha = 0.6f)),
        border = androidx.compose.foundation.BorderStroke(1.dp, DarkBorder)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Panduan",
                    tint = InfoBlue,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Syarat Pengaktifan Tombol Simpan:",
                    style = MaterialTheme.typography.labelMedium,
                    color = TextSecondary,
                    fontWeight = FontWeight.SemiBold
                )
            }

            ValidationItem(label = "Nama lengkap diisi (min. 3 karakter)", isValid = isNameValid)
            ValidationItem(label = "NIM tepat 10 digit numerik", isValid = isNimValid)
            ValidationItem(label = "Email mahasiswa valid (@ dan domain)", isValid = isEmailValid)
            ValidationItem(label = "Pernyataan keabsahan data dicentang", isValid = isAgreed)
        }
    }
}

@Composable
private fun ValidationItem(label: String, isValid: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            imageVector = if (isValid) Icons.Default.Check else Icons.Default.Close,
            contentDescription = null,
            tint = if (isValid) SuccessGreen else TextMuted,
            modifier = Modifier.size(14.dp)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = if (isValid) SuccessGreen else TextMuted
        )
    }
}
