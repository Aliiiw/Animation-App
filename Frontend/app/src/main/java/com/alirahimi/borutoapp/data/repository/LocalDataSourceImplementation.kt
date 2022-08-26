package com.alirahimi.borutoapp.data.repository

import com.alirahimi.borutoapp.data.local.BorutoAppDatabase
import com.alirahimi.borutoapp.domain.model.Hero
import com.alirahimi.borutoapp.domain.repository.LocalDataSource

class LocalDataSourceImplementation(borutoAppDatabase: BorutoAppDatabase) : LocalDataSource {

    private val heroDao = borutoAppDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}