package com.ngky.pointmax.data.database.details

import androidx.room.Embedded
import androidx.room.Relation
import com.ngky.pointmax.data.database.entity.CentPerPointCalculationEntity
import com.ngky.pointmax.data.database.entity.TransferPartnerCostEntity
import com.ngky.pointmax.data.database.entity.TravelPortalCostEntity
import com.ngky.pointmax.domain.model.CentPerPointCalculation

data class CentPerPointCalculationDetails(
  @Embedded
  val calculation: CentPerPointCalculationEntity,

  @Relation(
    entity = TravelPortalCostEntity::class,
    parentColumn = "id",
    entityColumn = "calculationId"
  )
  val portalCost: TravelPortalCostEntity,

  @Relation(
    entity = TransferPartnerCostEntity::class,
    parentColumn = "id",
    entityColumn = "calculationId"
  )
  val partnerCost: TransferPartnerCostEntity,
) {
  fun toDomainModel() = CentPerPointCalculation(
    id = calculation.id,
    title = calculation.title,
    cashPrice = calculation.cashPrice,
    travelPortalCost = portalCost.toDomainModel(),
    transferPartnerCost = partnerCost.toDomainModel()
  )
}
