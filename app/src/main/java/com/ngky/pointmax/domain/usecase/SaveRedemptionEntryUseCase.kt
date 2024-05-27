package com.ngky.pointmax.domain.usecase

import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.domain.repository.RedemptionEntryRepository

class SaveRedemptionEntryUseCase(
  private val redemptionEntryRepository: RedemptionEntryRepository
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
    redemptionEntryRepository.saveRedemptionEntry(
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

