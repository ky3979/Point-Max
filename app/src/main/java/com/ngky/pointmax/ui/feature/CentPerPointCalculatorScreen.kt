package com.ngky.pointmax.ui.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.ext.PointMaxPreview
import com.ngky.pointmax.ui.feature.section.CashPriceInput
import com.ngky.pointmax.ui.feature.section.CentsPerPointResults
import com.ngky.pointmax.ui.feature.section.TransferPartnerInput
import com.ngky.pointmax.ui.feature.section.TravelPortalInput
import com.ngky.pointmax.ui.theme.PointMaxTheme

@Composable
fun CentPerPointCalculatorScreen(
  modifier: Modifier = Modifier,
  uiState: CentPerPointCalculationUIState,
  onCashPriceChanged: (Double) -> Unit,
  onTravelPortalPointsChanged: (Int) -> Unit,
  onTravelPortalCompanyChanged: (TravelPortalCompany) -> Unit,
  onTransferPartnerPointsChanged: (Int) -> Unit,
  onTaxesAndFeesChanged: (Double) -> Unit,
  onTransferBonusChanged: (Float) -> Unit
) {
  LazyColumn(
    modifier = modifier,
    contentPadding = PaddingValues(PointMaxTheme.dimensions.padding3),
    verticalArrangement = Arrangement.spacedBy(PointMaxTheme.dimensions.padding3)
  ) {
    item {
      CentsPerPointResults(
        travelPortalCentsPerPoint = uiState.travelPortalCentsPerPoint,
        transferPartnerCentsPerPoint = uiState.transferPartnerCentsPerPoint,
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = PointMaxTheme.dimensions.padding4)
          .padding(horizontal = PointMaxTheme.dimensions.padding3)
      )
    }

    item {
      HorizontalDivider(
        thickness = PointMaxTheme.dimensions.divider,
        color = PointMaxTheme.colors.backgroundDivider,
        modifier = Modifier.padding(vertical = PointMaxTheme.dimensions.padding2)
      )
    }

    item {
      CashPriceInput(
        cashPrice = uiState.cashPrice,
        onPriceChange = onCashPriceChanged,
        modifier = Modifier.fillMaxWidth()
      )
      TravelPortalInput(
        travelPortalPoints = uiState.travelPortalPoints,
        travelPortalCompany = uiState.travelPortalCompany,
        onPortalPointsChange = onTravelPortalPointsChanged,
        onCompanyChange = onTravelPortalCompanyChanged,
        modifier = Modifier.fillMaxWidth()
      )
    }

    item {
      TransferPartnerInput(
        transferPartnerPoints = uiState.transferPartnerPoints,
        taxesAndFees = uiState.taxesAndFees,
        transferBonus = uiState.transferBonus,
        pointsToTransfer = uiState.pointsToTransfer,
        onPartnerPointsChange = onTransferPartnerPointsChanged,
        onTaxesAndFeesChange = onTaxesAndFeesChanged,
        onBonusChange = onTransferBonusChanged,
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}

@PointMaxPreview
@Composable
private fun CentPerPointCalculatorScreenPreview() {
  PointMaxTheme {
    var uiState by remember { mutableStateOf(CentPerPointCalculationUIState()) }
    CentPerPointCalculatorScreen(
      uiState = uiState,
      onCashPriceChanged = { uiState = uiState.copy(cashPrice = it)},
      onTravelPortalPointsChanged = { uiState = uiState.copy(travelPortalPoints = it) },
      onTravelPortalCompanyChanged = { uiState = uiState.copy(travelPortalCompany = it) },
      onTransferPartnerPointsChanged = { uiState = uiState.copy(transferPartnerPoints = it) },
      onTaxesAndFeesChanged = { uiState = uiState.copy(taxesAndFees = it) },
      onTransferBonusChanged = { uiState = uiState.copy(transferBonus = it) }
    )
  }
}
