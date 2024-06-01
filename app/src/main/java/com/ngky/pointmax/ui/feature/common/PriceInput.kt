package com.ngky.pointmax.ui.feature.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.ngky.pointmax.R
import com.ngky.pointmax.ext.PointMaxPreview
import com.ngky.pointmax.ui.theme.PointMaxTheme
import com.ngky.pointmax.ui.util.CurrencyAmountInputVisualTransformation
import java.math.BigDecimal

private const val PriceToInputConversionFactor = 100

@Composable
fun PriceInput(
  modifier: Modifier = Modifier,
  price: Double,
  label: String,
  supportingText: String? = null,
  onPriceChange: (Double) -> Unit
) {
  val priceString = remember(price) {
    val cleanedString = removeTrailingZeroes(price)
    if (cleanedString.startsWith("0")) {
      ""
    } else {
      cleanedString
    }
  }

  OutlinedTextField(
    value = priceString,
    onValueChange = {
      val cleanedPrice = try {
        it.trim()
          .replace(",", "")
          .replace(".", "")
          .toDouble() / PriceToInputConversionFactor
      } catch (e: NumberFormatException) {
        0.0
      }
      onPriceChange(cleanedPrice)
    },
    label = {
      Text(
        text = label,
        style = PointMaxTheme.typography.header3Bold,
        color = PointMaxTheme.colors.textPrimary
      )
    },
    prefix = {
      Text(
        text = stringResource(id = R.string.dollar_sign),
        style = PointMaxTheme.typography.body1Regular,
        color = PointMaxTheme.colors.textDark
      )
    },
    supportingText = {
      supportingText?.let {
        Text(
          text = it,
          style = PointMaxTheme.typography.label2Medium,
          color = PointMaxTheme.colors.textSecondary
        )
      }
    },
    textStyle = PointMaxTheme.typography.body1Regular,
    visualTransformation = CurrencyAmountInputVisualTransformation(),
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
    colors = TextFieldDefaults.colors(
      unfocusedIndicatorColor = PointMaxTheme.colors.backgroundPrimary,
      focusedIndicatorColor = PointMaxTheme.colors.backgroundPrimary,
      unfocusedContainerColor = PointMaxTheme.colors.backgroundStandard,
      focusedContainerColor = PointMaxTheme.colors.backgroundStandard
    ),
    modifier = modifier
  )
}

private fun removeTrailingZeroes(input: Double): String {
  return input.toBigDecimal()
    .multiply(BigDecimal(PriceToInputConversionFactor))
    .stripTrailingZeros()
    .toPlainString()
}

@PointMaxPreview
@Composable
private fun PriceInputPreview() {
  var input by remember { mutableDoubleStateOf(0.0) }
  PriceInput(
    price = input,
    label = "Price",
    onPriceChange = { input = it }
  )
}
