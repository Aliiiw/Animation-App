package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Hero


interface HeroRepository {

    val heroes: Map<Int, List<Hero>>

    //there is 15 heroes so every 3 heroes in one page
    val page1: List<Hero>
    val page2: List<Hero>
    val page3: List<Hero>
    val page4: List<Hero>
    val page5: List<Hero>


    suspend fun getAllHeroes(pages: Int): ApiResponse

    suspend fun searchHeroes(name: String): ApiResponse
}