package com.alirahimi.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alirahimi.borutoapp.data.local.data_access_object.HeroDao
import com.alirahimi.borutoapp.data.local.data_access_object.HeroRemoteKeyDao
import com.alirahimi.borutoapp.domain.model.Hero
import com.alirahimi.borutoapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoAppDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

}