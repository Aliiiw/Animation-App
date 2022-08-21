package com.alirahimi.borutoanimeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alirahimi.borutoanimeapp.data.local.data_access_object.HeroDao
import com.alirahimi.borutoanimeapp.data.local.data_access_object.HeroRemoteKeyDao
import com.alirahimi.borutoanimeapp.domain.model.Hero
import com.alirahimi.borutoanimeapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoAppDatabase : RoomDatabase() {

    abstract fun heroDataAccessObject(): HeroDao

    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao


}