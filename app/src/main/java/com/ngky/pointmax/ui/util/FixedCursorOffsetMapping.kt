package com.ngky.pointmax.ui.util

import androidx.compose.ui.text.input.OffsetMapping

class FixedCursorOffsetMapping(
  private val contentLength: Int,
  private val formattedContentLength: Int,
) : OffsetMapping {
  override fun originalToTransformed(offset: Int): Int = formattedContentLength
  override fun transformedToOriginal(offset: Int): Int = contentLength
}
