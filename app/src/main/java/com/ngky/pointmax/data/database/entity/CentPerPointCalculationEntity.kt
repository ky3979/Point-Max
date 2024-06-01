package com.ngky.pointmax.data.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "CentPerPointCalculation",
  indices = [Index("id")]
)
data class CentPerPointCalculationEntity(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,
  val title: String,
  val cashPrice: Double
)
