package com.alirahimi.borutoapp.presentation.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alirahimi.borutoapp.domain.model.OnBoardingPage
import com.alirahimi.borutoapp.ui.theme.*
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

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = ""
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = EXTRA_LARGE_PADDING),
            text = onBoardingPage.title,
            color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = MaterialTheme.colors.descriptionColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}