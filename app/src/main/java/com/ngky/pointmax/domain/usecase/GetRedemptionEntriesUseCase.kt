package com.ngky.pointmax.domain.usecase

import com.ngky.pointmax.domain.repository.RedemptionEntryRepository

class GetRedemptionEntriesUseCase(
  private val redemptionEntryRepository: RedemptionEntryRepository
) {
  operator fun invoke() = redemptionEntryRepository.getRedemptionEntryListFlow()
}
