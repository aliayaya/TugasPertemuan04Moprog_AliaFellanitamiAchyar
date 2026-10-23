package com.example.tugaspertemuan04_aliafellanitamiachyar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.DarkBackground
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.DarkBorder
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.DarkContainer
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.DarkSurface
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.ErrorRed
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.InfoBlue
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.MutedOlive
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.OliveContainer
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.SuccessContainer
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.SuccessGreen
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.TextMuted
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.TextPrimary
import com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme.TextSecondary

/**
 * 1. Stateless Header Bar Component
 */
@Composable
fun StatelessHeader(
    appName: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = DarkSurface),
        border = androidx.compose.foundation.BorderStroke(1.dp, DarkBorder)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = appName,
                    style = MaterialTheme.typography.titleMedium,
                    color = TextPrimary,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary
                )
            }
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(OliveContainer)
                    .border(1.dp, MutedOlive, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Avatar Profil",
                    tint = MutedOlive,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

/**
 * 2. Stateless Text Input Field with Validation State and Error Supporting Text
 * Demonstrates State Hoisting: receives value and emits onValueChange.
 */
@Composable
fun StatelessInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    leadingIcon: ImageVector,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorMessage: String? = null,
    singleLine: Boolean = true,
    maxLines: Int = 1
) {
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label, style = MaterialTheme.typography.bodyMedium) },
            placeholder = { Text(text = placeholder, color = TextMuted, style = MaterialTheme.typography.bodyMedium) },
            leadingIcon = {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = label,
                    tint = if (isError) ErrorRed else MutedOlive,
                    modifier = Modifier.size(20.dp)
                )
            },
            isError = isError,
            singleLine = singleLine,
            maxLines = maxLines,
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = TextPrimary,
                unfocusedTextColor = TextPrimary,
                focusedContainerColor = DarkBackground,
                unfocusedContainerColor = DarkBackground,
                errorContainerColor = DarkBackground,
                focusedBorderColor = MutedOlive,
                unfocusedBorderColor = DarkBorder,
                errorBorderColor = ErrorRed,
                focusedLabelColor = MutedOlive,
                unfocusedLabelColor = TextSecondary,
                errorLabelColor = ErrorRed
            ),
            modifier = Modifier.fillMaxWidth()
        )
        if (isError && errorMessage != null) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Error",
                    tint = ErrorRed,
                    modifier = Modifier.size(13.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = errorMessage,
                    color = ErrorRed,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

/**
 * 3. Stateless Numeric Stepper for Semester Selection
 * Demonstrates State Hoisting for numeric state with increment/decrement callbacks.
 */
@Composable
fun SemesterStepper(
    semester: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    minSemester: Int = 1,
    maxSemester: Int = 8,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f, fill = false)
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(DarkContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = "Semester",
                    tint = InfoBlue,
                    modifier = Modifier.size(16.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Semester Berjalan",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextPrimary,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Text(
                    text = "Rentang: $minSemester–$maxSemester",
                    style = MaterialTheme.typography.labelMedium,
                    color = TextSecondary,
                    maxLines = 1
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            FilledTonalIconButton(
                onClick = onDecrement,
                enabled = semester > minSemester,
                colors = IconButtonDefaults.filledTonalIconButtonColors(
                    containerColor = DarkContainer,
                    contentColor = TextPrimary,
                    disabledContainerColor = DarkContainer.copy(alpha = 0.4f),
                    disabledContentColor = TextSecondary.copy(alpha = 0.4f)
                ),
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Kurang",
                    modifier = Modifier.size(16.dp)
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(OliveContainer)
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Semester $semester",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextPrimary,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }

            FilledTonalIconButton(
                onClick = onIncrement,
                enabled = semester < maxSemester,
                colors = IconButtonDefaults.filledTonalIconButtonColors(
                    containerColor = DarkContainer,
                    contentColor = TextPrimary,
                    disabledContainerColor = DarkContainer.copy(alpha = 0.4f),
                    disabledContentColor = TextSecondary.copy(alpha = 0.4f)
                ),
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah",
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

/**
 * 4. Stateless Peminatan Selection Chips
 * Demonstrates selection state hoisting with multiple options.
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PeminatanSelectionGroup(
    selectedPeminatan: String,
    options: List<String>,
    onSelectionChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Peminatan / Jalur Keahlian",
            style = MaterialTheme.typography.bodyLarge,
            color = TextPrimary,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Pilih konsentrasi studi Anda:",
            style = MaterialTheme.typography.labelMedium,
            color = TextSecondary
        )
        Spacer(modifier = Modifier.height(6.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            options.forEach { option ->
                val isSelected = option == selectedPeminatan
                FilterChip(
                    selected = isSelected,
                    onClick = { onSelectionChange(option) },
                    label = {
                        Text(
                            text = option,
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (isSelected) TextPrimary else TextSecondary
                        )
                    },
                    leadingIcon = if (isSelected) {
                        {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Terpilih",
                                tint = MutedOlive,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    } else null,
                    shape = RoundedCornerShape(8.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = DarkBackground,
                        selectedContainerColor = OliveContainer,
                        selectedLabelColor = TextPrimary
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = isSelected,
                        borderColor = if (isSelected) MutedOlive else DarkBorder
                    )
                )
            }
        }
    }
}

/**
 * 5. Stateless Switch for Student Active Status
 */
@Composable
fun ActiveStatusSwitch(
    isActive: Boolean,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Status Keaktifan Kuliah",
                style = MaterialTheme.typography.bodyLarge,
                color = TextPrimary,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = if (isActive) "Mahasiswa Aktif" else "Non-Aktif / Cuti",
                style = MaterialTheme.typography.labelMedium,
                color = if (isActive) SuccessGreen else TextSecondary
            )
        }
        Switch(
            checked = isActive,
            onCheckedChange = onActiveChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = TextPrimary,
                checkedTrackColor = MutedOlive,
                uncheckedThumbColor = TextSecondary,
                uncheckedTrackColor = DarkContainer
            )
        )
    }
}

/**
 * 6. Stateless Checkbox for Data Agreement Confirmation
 */
@Composable
fun AgreementCheckbox(
    isAgreed: Boolean,
    onAgreedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onAgreedChange(!isAgreed) }
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isAgreed,
            onCheckedChange = onAgreedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = MutedOlive,
                uncheckedColor = TextSecondary,
                checkmarkColor = DarkBackground
            )
        )
        Text(
            text = "Saya menyatakan seluruh informasi biodata yang saya isi adalah benar dan akurat.",
            style = MaterialTheme.typography.bodyMedium,
            color = if (isAgreed) TextPrimary else TextSecondary,
            modifier = Modifier.weight(1f)
        )
    }
}

/**
 * 7. Stateless Action Buttons Row (Reset + Simpan Profil)
 */
@Composable
fun FormActionButtons(
    isFormValid: Boolean,
    onSave: () -> Unit,
    onReset: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            onClick = onReset,
            modifier = Modifier
                .weight(1f)
                .height(44.dp),
            contentPadding = PaddingValues(horizontal = 8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = TextSecondary
            ),
            border = androidx.compose.foundation.BorderStroke(1.dp, DarkBorder)
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reset",
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Reset",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium,
                maxLines = 1
            )
        }

        Button(
            onClick = onSave,
            enabled = isFormValid,
            modifier = Modifier
                .weight(1.4f)
                .height(44.dp),
            contentPadding = PaddingValues(horizontal = 8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MutedOlive,
                contentColor = TextPrimary,
                disabledContainerColor = DarkContainer,
                disabledContentColor = TextMuted
            )
        ) {
            Icon(
                imageVector = Icons.Default.Save,
                contentDescription = "Simpan",
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = if (isFormValid) "Simpan Biodata" else "Form Belum Valid",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1
            )
        }
    }
}

/**
 * 8. Stateless Profile Feedback / Summary Card
 * Appears when data has been saved, showing real-time feedback.
 */
@Composable
fun ProfileFeedbackCard(
    name: String,
    nim: String,
    email: String,
    bio: String,
    semester: Int,
    peminatan: String,
    isActive: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SuccessContainer.copy(alpha = 0.4f)),
        border = androidx.compose.foundation.BorderStroke(1.dp, SuccessGreen)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Sukses",
                    tint = SuccessGreen,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Profil Berhasil Disimpan!",
                    style = MaterialTheme.typography.titleMedium,
                    color = SuccessGreen,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(DarkBorder)
            )

            // Details
            SummaryRow(label = "Nama Mahasiswa", value = name)
            SummaryRow(label = "NIM", value = nim)
            SummaryRow(label = "Email Akademik", value = email)
            SummaryRow(label = "Semester", value = "Semester $semester")
            SummaryRow(label = "Peminatan", value = peminatan)
            SummaryRow(
                label = "Status",
                value = if (isActive) "Mahasiswa Aktif" else "Cuti Akademik"
            )
            if (bio.isNotBlank()) {
                SummaryRow(label = "Bio Singkat", value = bio)
            }
        }
    }
}

@Composable
private fun SummaryRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = TextPrimary,
            fontWeight = FontWeight.SemiBold
        )
    }
}
