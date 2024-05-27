package com.ngky.pointmax.domain.model

enum class TravelPortalCompany {
  AmericanExpress,
  CapitalOne,
  Chase;

  val cashBackValue: Double
    get() = when (this) {
      AmericanExpress -> 0.7
      CapitalOne -> 0.5
      Chase -> 1.0
    }
}