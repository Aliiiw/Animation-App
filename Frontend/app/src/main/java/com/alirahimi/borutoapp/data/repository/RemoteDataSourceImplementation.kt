package com.alirahimi.borutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alirahimi.borutoapp.data.local.BorutoAppDatabase
import com.alirahimi.borutoapp.data.paging_source.HeroRemoteMediator
import com.alirahimi.borutoapp.data.paging_source.SearchHeroesSource
import com.alirahimi.borutoapp.data.remote.BorutoApi
import com.alirahimi.borutoapp.domain.model.Hero
import com.alirahimi.borutoapp.domain.repository.RemoteDataSource
import com.alirahimi.borutoapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImplementation(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoAppDatabase
) : RemoteDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroesSource(borutoApi = borutoApi, query = query)
            }
        ).flow
    }
}