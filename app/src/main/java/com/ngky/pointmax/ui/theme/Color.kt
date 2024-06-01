package com.ngky.pointmax.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private object PointMaxColors {
  val royalBlue = Color(0xFF4169E1)
  val lightBlue = Color(0xFFB1C1EB)
  val gold = Color(0xFFFFD700)
  val lightGray = Color(0xFFF5F5F5)
  val darkSlateGray = Color(0xFF2F4F4F)
  val dimGray = Color(0xFF696969)
  val emeraldGreen = Color(0xFF50C878)
  val tomato = Color(0xFFFF6347)
  val white = Color.White
  val black = Color.Black
}

@Immutable
data class ExtendedPointMaxColors(
  val backgroundPrimary: Color,
  val backgroundSecondary: Color,
  val backgroundStandard: Color,
  val backgroundDivider: Color,

  val textPrimary: Color,
  val textSecondary: Color,
  val textStandard: Color,
  val textLight: Color,
  val textDark: Color,

  val success: Color,
  val error: Color
)

val pointMaxColorScheme = ExtendedPointMaxColors(
  backgroundPrimary = PointMaxColors.royalBlue,
  backgroundSecondary = PointMaxColors.gold,
  backgroundStandard = PointMaxColors.lightGray,
  backgroundDivider = PointMaxColors.lightBlue,

  textPrimary = PointMaxColors.darkSlateGray,
  textSecondary = PointMaxColors.dimGray,
  textStandard = PointMaxColors.royalBlue,
  textLight = PointMaxColors.white,
  textDark = PointMaxColors.black,

  success = PointMaxColors.emeraldGreen,
  error = PointMaxColors.tomato
)

val localExtendedPointMaxColors = staticCompositionLocalOf { pointMaxColorScheme }
