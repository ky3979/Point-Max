package com.ngky.pointmax.ui.feature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.domain.usecase.GetCentPerPointCalculationsUseCase
import com.ngky.pointmax.domain.usecase.SaveCentPerPointCalculationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

@HiltViewModel
class CentPerPointCalculatorViewModel @Inject constructor(
  private val getCentPerPointCalculationsUseCase: GetCentPerPointCalculationsUseCase,
  private val saveCentPerPointCalculationUseCase: SaveCentPerPointCalculationUseCase
) : ViewModel() {

  var uiState by mutableStateOf(CentPerPointCalculationUIState())
    private set

  fun onCashPriceChanged(cashPrice: Double) {
    uiState = uiState.copy(cashPrice = cashPrice)
  }

  fun onTravelPortalPointsChanged(travelPortalCost: Int) {
    uiState = uiState.copy(travelPortalPoints = travelPortalCost)
  }

  fun onTravelPortalCompanyChanged(travelPortalCompany: TravelPortalCompany) {
    uiState = uiState.copy(travelPortalCompany = travelPortalCompany)
  }

  fun onTransferPartnerPointsChanged(transferPartnerCost: Int) {
    uiState = uiState.copy(transferPartnerPoints = transferPartnerCost)
  }

  fun onTaxesAndFeesChanged(taxesAndFees: Double) {
    uiState = uiState.copy(taxesAndFees = taxesAndFees)
  }

  fun onTransferBonusChanged(transferBonus: Float) {
    uiState = uiState.copy(transferBonus = transferBonus)
  }
}

data class CentPerPointCalculationUIState(
  val cashPrice: Double = 0.0,
  val travelPortalPoints: Int = 0,
  val travelPortalCompany: TravelPortalCompany = TravelPortalCompany.Chase,
  val transferPartnerPoints: Int = 0,
  val taxesAndFees: Double = 0.0,
  val transferBonus: Float = 0.0f,
) {
  val pointsToTransfer: Int
    get() {
      val pointsDecimal = transferPartnerPoints.toBigDecimal()
      val bonusDecimal = transferBonus.toBigDecimal()
      return pointsDecimal.subtract(pointsDecimal.multiply(bonusDecimal)).toInt()
    }

  val travelPortalCentsPerPoint: Float
    get() {
      if (travelPortalPoints == 0) {
        return 1.0f
      }
      return (cashPrice / travelPortalPoints.toDouble() * 100f).toFloat()
    }

  val transferPartnerCentsPerPoint: Float
    get() {
      if (transferPartnerPoints == 0) {
        return 1.0f
      }
      return ((cashPrice - taxesAndFees) / pointsToTransfer.toDouble() * 100f).toFloat()
    }
}
