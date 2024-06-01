package com.ngky.pointmax.ui.feature.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.ngky.pointmax.R
import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.ext.PointMaxPreview
import com.ngky.pointmax.ui.feature.common.DropdownMenu
import com.ngky.pointmax.ui.feature.common.PointInput
import com.ngky.pointmax.ui.feature.common.PriceInput
import com.ngky.pointmax.ui.theme.PointMaxTheme

@Composable
fun TransferPartnerInput(
  modifier: Modifier = Modifier,
  transferPartnerPoints: Int,
  taxesAndFees: Double,
  transferBonus: Float,
  pointsToTransfer: Int,
  onPartnerPointsChange: (Int) -> Unit,
  onTaxesAndFeesChange: (Double) -> Unit,
  onBonusChange: (Float) -> Unit
) {
  val context = LocalContext.current
  val bonusOptions = remember {
    val percentages = listOf(0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f)
    percentages.map { context.getString(R.string.percent_format, it * 100) }
  }
  val currentBonus = remember(transferBonus) {
    context.getString(R.string.percent_format, transferBonus * 100)
  }

  Column(
    modifier = modifier,
  ) {
    PointInput(
      points = transferPartnerPoints,
      label = stringResource(id = R.string.transfer_partner_points),
      onPointChange = onPartnerPointsChange,
      modifier = Modifier.fillMaxWidth()
    )
    Row(
      horizontalArrangement = Arrangement.spacedBy(PointMaxTheme.dimensions.padding0)
    ) {
      PriceInput(
        price = taxesAndFees,
        label = stringResource(id = R.string.taxes_and_fees),
        supportingText = stringResource(id = R.string.points_to_transfer),
        onPriceChange = onTaxesAndFeesChange,
        modifier = Modifier.weight(0.55f)
      )
      DropdownMenu(
        selectedValue = currentBonus,
        options = bonusOptions,
        label = stringResource(id = R.string.card),
        supportingText = stringResource(id = R.string.point_format, pointsToTransfer),
        onValueChange = { percentageString ->
          val selectedBonus = percentageString.replace("%", "").toFloat() / 100
          onBonusChange(selectedBonus)
        },
        modifier = Modifier.weight(0.45f)
      )
    }
  }
}

@PointMaxPreview
@Composable
private fun TransferPartnerInputPreview() {
  var points by remember { mutableIntStateOf(0) }
  var taxesAndFees by remember { mutableDoubleStateOf(0.0) }
  var bonus by remember { mutableFloatStateOf(0.0f) }
  val pointsToTransfer = remember(points, bonus) {
    val pointsDecimal = points.toBigDecimal()
    val bonusDecimal = bonus.toBigDecimal()
    pointsDecimal.subtract(pointsDecimal.multiply(bonusDecimal)).toInt()
  }
  TransferPartnerInput(
    transferPartnerPoints = points,
    taxesAndFees = taxesAndFees,
    transferBonus = bonus,
    pointsToTransfer = pointsToTransfer,
    onPartnerPointsChange = { points = it },
    onTaxesAndFeesChange = { taxesAndFees = it },
    onBonusChange = { bonus = it }
  )
}
