package com.ngky.pointmax.data.database.details

import androidx.room.Embedded
import androidx.room.Relation
import com.ngky.pointmax.data.database.entity.RedemptionEntryEntity
import com.ngky.pointmax.data.database.entity.TransferPartnerCostEntity
import com.ngky.pointmax.data.database.entity.TravelPortalCostEntity
import com.ngky.pointmax.domain.model.RedemptionEntry

data class RedemptionEntryDetails(
  @Embedded
  val entry: RedemptionEntryEntity,

  @Relation(
    entity = TravelPortalCostEntity::class,
    parentColumn = "id",
    entityColumn = "entryId"
  )
  val portalCost: TravelPortalCostEntity,

  @Relation(
    entity = TransferPartnerCostEntity::class,
    parentColumn = "id",
    entityColumn = "entryId"
  )
  val partnerCost: TransferPartnerCostEntity,
) {
  fun toDomainModel() = RedemptionEntry(
    id = entry.id,
    title = entry.title,
    cashPrice = entry.cashPrice,
    travelPortalCost = portalCost.toDomainModel(),
    transferPartnerCost = partnerCost.toDomainModel()
  )
}
