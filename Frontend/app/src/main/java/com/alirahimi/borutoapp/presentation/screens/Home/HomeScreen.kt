package com.alirahimi.borutoapp.presentation.screens.Home

import android.graphics.Color
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.alirahimi.borutoapp.navigation.Screen
import com.alirahimi.borutoapp.presentation.common.ListContent
import com.alirahimi.borutoapp.ui.theme.statusBarColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HomeScreen(
    navigationController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()

) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.statusBarColor
    )

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