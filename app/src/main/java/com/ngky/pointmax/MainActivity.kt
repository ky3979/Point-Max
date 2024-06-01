package com.ngky.pointmax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ngky.pointmax.ui.feature.CentPerPointCalculatorScreen
import com.ngky.pointmax.ui.feature.CentPerPointCalculatorViewModel
import com.ngky.pointmax.ui.theme.PointMaxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private val centPerPointViewModel: CentPerPointCalculatorViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      PointMaxTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          containerColor = PointMaxTheme.colors.backgroundStandard
        ) { innerPadding ->
          CentPerPointCalculatorScreen(
            uiState = centPerPointViewModel.uiState,
            onCashPriceChanged = centPerPointViewModel::onCashPriceChanged,
            onTravelPortalPointsChanged = centPerPointViewModel::onTravelPortalPointsChanged,
            onTravelPortalCompanyChanged = centPerPointViewModel::onTravelPortalCompanyChanged,
            onTransferPartnerPointsChanged = centPerPointViewModel::onTransferPartnerPointsChanged,
            onTaxesAndFeesChanged = centPerPointViewModel::onTaxesAndFeesChanged,
            onTransferBonusChanged = centPerPointViewModel::onTransferBonusChanged,
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding())
          )
        }
      }
    }
  }
}
