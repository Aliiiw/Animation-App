package com.alirahimi.borutoapp.presentation.screens.Home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.alirahimi.borutoapp.presentation.common.ListContent
import com.alirahimi.borutoapp.presentation.components.RatingWidget
import com.alirahimi.borutoapp.ui.theme.LARGE_PADDING

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HomeScreen(
    navigationController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()

) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})

        },
        content = {
            ListContent(
                heroes = allHeroes,
                navigationController = navigationController
            )
        }
    )
}