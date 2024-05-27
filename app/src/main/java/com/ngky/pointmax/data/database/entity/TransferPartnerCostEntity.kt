package com.ngky.pointmax.data.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ngky.pointmax.domain.model.TransferPartnerCost

@Entity(
  tableName = "TransferPartnerCost",
  foreignKeys = [
    ForeignKey(
      entity = RedemptionEntryEntity::class,
      parentColumns = ["id"],
      childColumns = ["entryId"],
      onDelete = ForeignKey.CASCADE
    )
  ],
  indices = [
    Index("id"),
    Index("entryId")
  ]
)
data class TransferPartnerCostEntity(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,
  val entryId: Long,
  val points: Int,
  val taxesAndFees: Double,
  val transferBonus: Float
) {
  fun toDomainModel() = TransferPartnerCost(
    id = id,
    points = points,
    taxesAndFees = taxesAndFees,
    transferBonus = transferBonus
  )
}
