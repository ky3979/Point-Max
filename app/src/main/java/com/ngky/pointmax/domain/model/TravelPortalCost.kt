package com.ngky.pointmax.domain.model

data class TravelPortalCost(
  val id: Long = 0,
  val points: Int,
  val company: TravelPortalCompany
)
