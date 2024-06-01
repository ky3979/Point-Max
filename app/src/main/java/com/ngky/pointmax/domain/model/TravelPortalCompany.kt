package com.ngky.pointmax.domain.model

import com.ngky.pointmax.R

enum class TravelPortalCompany {
  AmericanExpress,
  CapitalOne,
  Chase;

  companion object {
    fun fromString(value: String): TravelPortalCompany {
      return when (value) {
        "Amex" -> AmericanExpress
        "Capital One" -> CapitalOne
        "Chase" -> Chase
        else -> throw IllegalArgumentException("Unknown travel portal company: $value")
      }
    }
  }

  val cashBackValue: Float
    get() = when (this) {
      AmericanExpress -> 0.7f
      CapitalOne -> 0.5f
      Chase -> 1.0f
    }

  val textResId: Int
    get() = when (this) {
      AmericanExpress -> R.string.american_express
      CapitalOne -> R.string.capital_one
      Chase -> R.string.chase
    }
}
