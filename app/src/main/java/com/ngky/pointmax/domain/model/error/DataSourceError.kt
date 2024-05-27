package com.ngky.pointmax.domain.model.error

sealed class DataSourceError(cause: Throwable?) : PointMaxError(cause){
  data object NullEntity : DataSourceError(null) {
    private fun readResolve(): Any = NullEntity
  }

  data class SQLException(val sqlException: android.database.SQLException) : DataSourceError(sqlException)
  data class UnknownError(val exception: Throwable) : DataSourceError(exception)
}
