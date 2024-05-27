package com.ngky.pointmax.ext

import android.database.SQLException
import com.ngky.pointmax.domain.model.error.DataSourceError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import timber.log.Timber

fun <T> Flow<T>.safeFlow(): Flow<T> = catch { cause ->
  Timber.e(cause, "Failed to evaluate safeFlow. Throwing PointMax Error")
  throw when (cause) {
    is NullPointerException, is IllegalStateException -> DataSourceError.NullEntity
    else -> DataSourceError.UnknownError(cause)
  }
}

@Throws(DataSourceError::class)
suspend fun safeDatabaseCall(request: suspend () -> Unit) {
  try {
    request()
  } catch (cause: Exception) {
    Timber.e(cause, "Failed to evaluate a safeDatabaseCall. Throwing PointMax Error")
    throw when (cause) {
      is SQLException -> DataSourceError.SQLException(cause)
      else -> DataSourceError.UnknownError(cause)
    }
  }
}
