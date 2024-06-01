package com.ngky.pointmax.ui.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.DecimalFormat

class PointAmountInputVisualTransformation : VisualTransformation {

  private val symbols = DecimalFormat().decimalFormatSymbols

  override fun filter(text: AnnotatedString): TransformedText {
    val thousandsSeparator = symbols.groupingSeparator

    val inputText = text.text

    val formattedPoints = inputText
      .reversed()
      .chunked(3)
      .joinToString(thousandsSeparator.toString())
      .reversed()

    val newText = AnnotatedString(
      text = formattedPoints,
      spanStyles = text.spanStyles,
      paragraphStyles = text.paragraphStyles
    )

    val offsetMapping = FixedCursorOffsetMapping(
      contentLength = inputText.length,
      formattedContentLength = formattedPoints.length
    )

    return TransformedText(newText, offsetMapping)
  }
}
