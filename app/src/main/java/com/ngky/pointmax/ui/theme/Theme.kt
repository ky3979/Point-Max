package com.ngky.pointmax.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext

@Composable
fun PointMaxTheme(
  content: @Composable () -> Unit
) {
  CompositionLocalProvider(
    localExtendedPointMaxColors provides pointMaxColorScheme,
    localExtendedPointMaxTypography provides pointMaxTypography,
    content = content
  )
}

object PointMaxTheme {
  val colors: ExtendedPointMaxColors
    @Composable
    @ReadOnlyComposable
    get() = localExtendedPointMaxColors.current

  val typography: ExtendedPointMaxTypography
    @Composable
    @ReadOnlyComposable
    get() = localExtendedPointMaxTypography.current
}
