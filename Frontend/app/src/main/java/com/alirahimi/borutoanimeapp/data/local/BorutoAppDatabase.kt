package com.alirahimi.borutoanimeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alirahimi.borutoanimeapp.data.local.data_access_object.HeroDao
import com.alirahimi.borutoanimeapp.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class BorutoAppDatabase : RoomDatabase() {

    abstract fun heroDataAccessObject(): HeroDao

}