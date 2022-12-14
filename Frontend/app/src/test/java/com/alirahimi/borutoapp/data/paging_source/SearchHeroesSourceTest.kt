package com.alirahimi.borutoapp.data.paging_source

import androidx.paging.PagingSource.LoadParams
import androidx.paging.PagingSource.LoadResult
import com.alirahimi.borutoapp.data.remote.BorutoApi
import com.alirahimi.borutoapp.data.remote.FakeApi
import com.alirahimi.borutoapp.domain.model.Hero
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class SearchHeroesSourceTest {

    private lateinit var borutoApi: BorutoApi
    private lateinit var heroes: List<Hero>

    @Before
    fun setup() {
        borutoApi = FakeApi()
        heroes = listOf(
            Hero(
                id = 1,
                name = "Sasuke",
                image = "",
                about = "",
                rating = 5.0,
                power = 0,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            ),
            Hero(
                id = 2,
                name = "Naruto",
                image = "",
                about = "",
                rating = 5.0,
                power = 0,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            ),
            Hero(
                id = 3,
                name = "Sakura",
                image = "",
                about = "",
                rating = 5.0,
                power = 0,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            )
        )
    }

    @Test
    fun `Search api with existing hero name, expect single hero result, assert LoadResult_Page`() =
        runBlocking {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Sasuke")
            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first()),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with existing hero name, expect multiple hero result, assert LoadResult_Page`() =
        runBlocking {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Sa")
            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first(), heroes[2]),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        key = null,
                        loadSize = 3,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api with empty hero name, assert empty heroes list and LoadResult_Page`() =
        runBlocking {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "")
            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )

            val result = borutoApi.searchHeroes("").heroes

            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }

    @Test
    fun `Search api with non_existing hero name, assert empty heroes list and LoadResult_Page`() =
        runBlocking {
            val heroSource = SearchHeroesSource(borutoApi = borutoApi, query = "Unknown")
            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            )

            val result = borutoApi.searchHeroes("Unknown").heroes

            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }
}