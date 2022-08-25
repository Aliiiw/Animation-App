package com.alirahimi.borutoapp.presentation.components

import android.icu.number.Scale
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alirahimi.borutoapp.R
import com.alirahimi.borutoapp.ui.theme.EXTRA_SMALL_PADDING
import com.alirahimi.borutoapp.ui.theme.LightGray
import com.alirahimi.borutoapp.ui.theme.StarColor

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double,

    ) {


    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }

    FilledStar(starPath = starPath, starPathBounds = starPathBounds)


}

@Composable
fun FilledStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float = 2f
) {
    Canvas(modifier = Modifier.size(24.dp)) {

        val canvasSize = this.size

        scale(scale = scaleFactor) {

            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(top = top, left = left) {
                drawPath(
                    path = starPath,
                    color = StarColor
                )
            }
        }
    }
}