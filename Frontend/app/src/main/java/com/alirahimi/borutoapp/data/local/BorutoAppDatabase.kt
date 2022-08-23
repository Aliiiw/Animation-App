package com.alirahimi.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alirahimi.borutoapp.data.local.data_access_object.HeroDao
import com.alirahimi.borutoapp.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class BorutoAppDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

}