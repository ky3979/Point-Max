package com.ngky.pointmax.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun PointMaxTheme(
  content: @Composable () -> Unit
) {
  CompositionLocalProvider(
    localExtendedPointMaxColors provides pointMaxColorScheme,
    localExtendedPointMaxTypography provides pointMaxTypography,
    localExtendedPointMaxDimensions provides pointMaxDimensions,
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

  val dimensions: ExtendedPointMaxDimensions
    @Composable
    @ReadOnlyComposable
    get() = localExtendedPointMaxDimensions.current
}
