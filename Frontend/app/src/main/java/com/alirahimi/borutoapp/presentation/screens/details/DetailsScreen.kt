package com.alirahimi.borutoapp.presentation.screens.details


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun DetailsScreen(
    navigationController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val selectedHero by detailsViewModel.selectedHero.collectAsState()

    DetailsContent(
        navigationController = navigationController,
        selectedHero = selectedHero
    )
}