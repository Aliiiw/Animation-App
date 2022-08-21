package com.alirahimi.borutoanimeapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alirahimi.borutoanimeapp.utilities.Constants.HERO_REMOTE_KEY_DATABASE_TABLE

@Entity(tableName = HERO_REMOTE_KEY_DATABASE_TABLE)
data class HeroRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val previousKey: Int?,
    val nextKey: Int?
)
