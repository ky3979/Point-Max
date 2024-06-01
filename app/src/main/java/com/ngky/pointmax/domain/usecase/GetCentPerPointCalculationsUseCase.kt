package com.ngky.pointmax.domain.usecase

import com.ngky.pointmax.domain.repository.CentPerPointCalculationRepository
import javax.inject.Inject

class GetCentPerPointCalculationsUseCase @Inject constructor(
  private val centPerPointCalculationRepository: CentPerPointCalculationRepository
) {
  operator fun invoke() = centPerPointCalculationRepository.getCalculationListFlow()
}
