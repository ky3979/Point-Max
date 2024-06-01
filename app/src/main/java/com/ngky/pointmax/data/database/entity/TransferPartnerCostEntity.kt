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
      entity = CentPerPointCalculationEntity::class,
      parentColumns = ["id"],
      childColumns = ["calculationId"],
      onDelete = ForeignKey.CASCADE
    )
  ],
  indices = [
    Index("id"),
    Index("calculationId")
  ]
)
data class TransferPartnerCostEntity(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,
  val calculationId: Long,
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
