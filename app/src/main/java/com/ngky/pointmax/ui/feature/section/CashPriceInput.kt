package com.ngky.pointmax.ui.feature.section

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ngky.pointmax.R
import com.ngky.pointmax.ext.PointMaxPreview
import com.ngky.pointmax.ui.feature.common.PriceInput
import com.ngky.pointmax.ui.theme.PointMaxTheme

@Composable
fun CashPriceInput(
  modifier: Modifier = Modifier,
  cashPrice: Double,
  onPriceChange: (Double) -> Unit
) {
  Box(modifier = modifier) {
    PriceInput(
      price = cashPrice,
      label = stringResource(id = R.string.cash_price_of_flight_or_hotel),
      onPriceChange = onPriceChange,
      modifier = Modifier.fillMaxWidth()
    )
  }
}


@Composable
@PointMaxPreview
private fun CashPriceInputPreview() {
  var input by remember { mutableDoubleStateOf(0.0) }
  CashPriceInput(
    cashPrice = input,
    onPriceChange = { input = it }
  )
}
