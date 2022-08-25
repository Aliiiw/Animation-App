package com.alirahimi.borutoapp.presentation.screens.Home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.alirahimi.borutoapp.navigation.Screen
import com.alirahimi.borutoapp.presentation.common.ListContent

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HomeScreen(
    navigationController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()

) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {
                navigationController.navigate(Screen.Search.route)
            })
        },
        content = {
            ListContent(
                heroes = allHeroes,
                navigationController = navigationController
            )
        }
    )
}