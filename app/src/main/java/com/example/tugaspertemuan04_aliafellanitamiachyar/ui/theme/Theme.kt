package com.example.tugaspertemuan04_aliafellanitamiachyar.ui.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkSlateColorScheme = darkColorScheme(
    primary = MutedOlive,
    onPrimary = DarkBackground,
    primaryContainer = OliveContainer,
    onPrimaryContainer = TextPrimary,
    secondary = InfoBlue,
    background = DarkBackground,
    surface = DarkSurface,
    surfaceVariant = DarkContainer,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    onSurfaceVariant = TextSecondary,
    outline = DarkBorder,
    error = ErrorRed,
    errorContainer = ErrorContainer,
    onError = DarkBackground
)

@Composable
fun TugasPertemuan04_AliaFellanitamiAchyarTheme(
    darkTheme: Boolean = true, // Default to Dark Theme
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        else -> DarkSlateColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
