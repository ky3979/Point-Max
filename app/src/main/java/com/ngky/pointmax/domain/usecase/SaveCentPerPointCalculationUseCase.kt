package com.ngky.pointmax.domain.usecase

import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.domain.repository.CentPerPointCalculationRepository
import javax.inject.Inject

class SaveCentPerPointCalculationUseCase @Inject constructor(
  private val centPerPointCalculationRepository: CentPerPointCalculationRepository
) {
  suspend operator fun invoke(
    title: String,
    cashPrice: Double,
    travelPortalPoints: Int,
    travelPortalCompany: TravelPortalCompany,
    transferPartnerPoints: Int,
    transferPartnerTaxesAndFees: Double,
    transferPartnerBonus: Float
  ) {
    centPerPointCalculationRepository.saveCalculation(
      title = title,
      cashPrice = cashPrice,
      travelPortalPoints = travelPortalPoints,
      travelPortalCompany = travelPortalCompany,
      transferPartnerPoints = transferPartnerPoints,
      transferPartnerTaxesAndFees = transferPartnerTaxesAndFees,
      transferPartnerBonus = transferPartnerBonus
    )
  }
}

