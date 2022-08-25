package com.alirahimi.borutoapp.presentation.screens.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.alirahimi.borutoapp.presentation.common.ListContent

@ExperimentalCoilApi
@Composable
fun SearchScreen(
) {

    Scaffold(
        topBar = {
            SearchTopBar(
                text = "",
                onSearchClicked = {},
                onCloseClicked = {},
                onTextChange = {}
            )
        },
        content = {}
    )
}