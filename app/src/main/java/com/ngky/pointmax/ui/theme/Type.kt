package com.ngky.pointmax.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.ngky.pointmax.R

@Immutable
data class ExtendedPointMaxTypography(
  val header1Bold: TextStyle,
  val header2Bold: TextStyle,
  val header3Bold: TextStyle,
  val body1Regular: TextStyle,
  val body2Regular: TextStyle,
  val labelRegular: TextStyle,
  val inputRegular: TextStyle,
  val buttonMedium: TextStyle,
)

private val provider = GoogleFont.Provider(
  providerAuthority = "com.google.android.gms.fonts",
  providerPackage = "com.google.android.gms",
  certificates = R.array.com_google_android_gms_fonts_certs
)

private val openSans = FontFamily(
  Font(
    googleFont = GoogleFont("Open Sans"),
    fontProvider = provider
  )
)

val pointMaxTypography = ExtendedPointMaxTypography(
  header1Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
    lineHeight = 32.sp,
  ),
  header2Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 32.sp,
  ),
  header3Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 24.sp,
  ),
  body1Regular = TextStyle(
    fontFamily = openSans,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.15.sp,
  ),
  body2Regular = TextStyle(
    fontFamily = openSans,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp,
  ),
  labelRegular = TextStyle(
    fontFamily = openSans,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.1.sp,
  ),
  inputRegular = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
  ),
  buttonMedium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp,
  )
)

val localExtendedPointMaxTypography = staticCompositionLocalOf { pointMaxTypography }
