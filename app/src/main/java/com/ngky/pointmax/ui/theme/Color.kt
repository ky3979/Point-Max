package com.ngky.pointmax.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private object PointMaxColors {
  val royalBlue = Color(0xFF4169E1)
  val gold = Color(0xFFFFD700)
  val lightGray = Color(0xFFF5F5F5)
  val darkSlateGray = Color(0xFF2F4F4F)
  val dimGray = Color(0xFF696969)
  val emeraldGreen = Color(0xFF50C878)
  val tomato = Color(0xFFFF6347)
  val white = Color(0xFFFFFFFF)
}

@Immutable
data class ExtendedPointMaxColors(
  val primaryButtonBackground: Color,
  val secondaryButtonBackground: Color,

  val primaryButtonText: Color,
  val secondaryButtonText: Color,

  val primaryBackground: Color,
  val iconBackground: Color,

  val headerText: Color,
  val primaryText: Color,
  val secondaryText: Color,

  val success: Color,
  val error: Color
)

val pointMaxColorScheme = ExtendedPointMaxColors(
  primaryButtonBackground = PointMaxColors.royalBlue,
  secondaryButtonBackground = PointMaxColors.gold,

  primaryButtonText = PointMaxColors.white,
  secondaryButtonText = PointMaxColors.dimGray,

  primaryBackground = PointMaxColors.lightGray,
  iconBackground = PointMaxColors.gold,

  headerText = PointMaxColors.royalBlue,
  primaryText = PointMaxColors.darkSlateGray,
  secondaryText = PointMaxColors.dimGray,

  success = PointMaxColors.emeraldGreen,
  error = PointMaxColors.tomato
)

val localExtendedPointMaxColors = staticCompositionLocalOf { pointMaxColorScheme }
