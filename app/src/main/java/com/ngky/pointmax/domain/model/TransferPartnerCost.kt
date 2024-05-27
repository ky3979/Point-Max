package com.ngky.pointmax.domain.model

data class TransferPartnerCost(
  val id: Long = 0,
  val points: Int,
  val taxesAndFees: Double,
  val transferBonus: Float
)
