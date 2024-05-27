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
data class TravelPortalCostEntity(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,
  val entryId: Long,
  val points: Int,
  val company: TravelPortalCompany
) {
  fun toDomainModel() = TravelPortalCost(
    id = id,
    points = points,
    company = company
  )
}