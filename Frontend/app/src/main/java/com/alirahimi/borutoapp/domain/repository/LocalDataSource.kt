package com.alirahimi.borutoapp.domain.repository

import com.alirahimi.borutoapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}