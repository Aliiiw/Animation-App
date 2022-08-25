package com.alirahimi.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alirahimi.borutoapp.util.Constants.HERO_REMOTE_KEYS_DATABASE_TABLE

@Entity(tableName = HERO_REMOTE_KEYS_DATABASE_TABLE)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val previousPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)
