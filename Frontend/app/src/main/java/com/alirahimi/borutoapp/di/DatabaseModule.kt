package com.alirahimi.borutoapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alirahimi.borutoapp.data.local.BorutoAppDatabase
import com.alirahimi.borutoapp.data.repository.LocalDataSourceImplementation
import com.alirahimi.borutoapp.domain.repository.LocalDataSource
import com.alirahimi.borutoapp.util.Constants.BORUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): BorutoAppDatabase {
        return Room.databaseBuilder(
            context,
            BorutoAppDatabase::class.java,
            BORUTO_DATABASE
        ).build()
    }


    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: BorutoAppDatabase
    ): LocalDataSource {
        return LocalDataSourceImplementation(borutoAppDatabase = database)
    }
}

