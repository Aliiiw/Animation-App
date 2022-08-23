package com.alirahimi.borutoapp.presentation.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.alirahimi.borutoapp.domain.model.OnBoardingPage
import com.alirahimi.borutoapp.ui.theme.welcomeScreenBackgroundColor
import com.alirahimi.borutoapp.util.Constants.NUMBER_OF_BOARDING_PAGES
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(navigationController: NavHostController) {

    val pages = listOf(
        OnBoardingPage.FirstPage,
        OnBoardingPage.SecondPage,
        OnBoardingPage.ThirdPage,
    )

    val pagerState = rememberPagerState(0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colors.welcomeScreenBackgroundColor
            )
    ) {
        HorizontalPager(
            state = pagerState,
            count = NUMBER_OF_BOARDING_PAGES,
            verticalAlignment = Alignment.Top
        ) { page ->
            PagerScreen(onBoardingPage = pages[page])
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {

}