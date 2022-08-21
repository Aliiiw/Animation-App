package com.alirahimi.borutoanimeapp.data.local.data_access_object

import androidx.paging.PagingSource
import androidx.room.Dao   //data access object
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alirahimi.borutoanimeapp.domain.model.Hero

@Dao
interface HeroDao {

    @Query("SELECT * FROM hero_table ORDER BY id ASC")
    fun getAllHeroes(): PagingSource<Int, Hero>

    @Query("SELECT * FROM hero_table WHERE id=:heroId")
    fun getSelectedHero(heroId: Int): Hero

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeroes(heroes: List<Hero>)

    @Query("DELETE  FROM hero_table")
    suspend fun deleteAllHeroes(heroes: List<Hero>)

}