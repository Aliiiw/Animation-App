package com.alirahimi.borutoapp.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.alirahimi.borutoapp.R
import com.alirahimi.borutoapp.ui.theme.mainColor
import com.alirahimi.borutoapp.ui.theme.mainColor2
import com.alirahimi.borutoapp.ui.theme.mainColor3
import com.alirahimi.borutoapp.ui.theme.mainColor4

@Composable
fun SplashScreen(navigationController: NavHostController) {

    val rotate = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        rotate.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
    }

    Splash(rotate = rotate.value)

}


@Composable
fun Splash(rotate: Float) {

    if (isSystemInDarkTheme()) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                modifier = Modifier.rotate(degrees = rotate),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo)
            )

        }
    } else {
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(mainColor, mainColor2, mainColor3, mainColor4)
                    )
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                modifier = Modifier.rotate(degrees = rotate),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo)
            )
        }
    }
}