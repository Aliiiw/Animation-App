package com.alirahimi.borutoapp.presentation.screens.Home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})

        }
    ) {

    }
}