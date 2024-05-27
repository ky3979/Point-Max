package com.ngky.pointmax.domain.model

data class RedemptionEntry(
  val id: Long = 0,
  val title: String,
  val cashPrice: Double,
  val travelPortalCost: TravelPortalCost,
  val transferPartnerCost: TransferPartnerCost
)
