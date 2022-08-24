package com.alirahimi.borutoapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.alirahimi.borutoapp.data.repository.Repository
import com.alirahimi.borutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}