package com.ngky.pointmax.di

import android.content.Context
import androidx.room.Room
import com.ngky.pointmax.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {
  @Provides
  @Singleton
  fun provideAppDatabase(
    @ApplicationContext context: Context
  ): AppDatabase {
    return Room.databaseBuilder(
      context = context,
      klass = AppDatabase::class.java,
      name = AppDatabase.DATABASE_NAME
    ).build()
  }
}