package com.ngky.pointmax.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class ExtendedPointMaxDimensions(
  val padding0: Dp,
  val padding1: Dp,
  val padding2: Dp,
  val padding3: Dp,
  val padding4: Dp,
  val padding5: Dp,

  val border: Dp,
  val divider: Dp,
  val button: Dp,
  val input: Dp
)

val pointMaxDimensions = ExtendedPointMaxDimensions(
  padding0 = 4.dp,
  padding1 = 8.dp,
  padding2 = 12.dp,
  padding3 = 16.dp,
  padding4 = 20.dp,
  padding5 = 24.dp,

  border = 1.dp,
  divider = 1.dp,
  button = 48.dp,
  input = 32.dp
)

val localExtendedPointMaxDimensions = staticCompositionLocalOf { pointMaxDimensions }
