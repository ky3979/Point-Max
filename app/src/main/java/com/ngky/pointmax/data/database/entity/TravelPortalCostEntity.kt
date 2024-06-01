package com.ngky.pointmax.data.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.domain.model.TravelPortalCost

@Entity(
  tableName = "TravelPortalCost",
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
data class TravelPortalCostEntity(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,
  val calculationId: Long,
  val points: Int,
  val company: TravelPortalCompany
) {
  fun toDomainModel() = TravelPortalCost(
    id = id,
    points = points,
    company = company
  )
}
