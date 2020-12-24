package com.meksconway.composesampletravelappui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.meksconway.composesampletravelappui.MainViewModel
import com.meksconway.composesampletravelappui.R
import com.meksconway.composesampletravelappui.ScreenState
import com.meksconway.composesampletravelappui.ui.typography

@Composable
fun OnBoardingPage() {

    val viewModel: MainViewModel = viewModel()
    viewModel.screenState.value = ScreenState.ON_BOARDING


    val backgroundImage = loadImageResource(id = R.drawable.splash).resource.resource

    Box(modifier = Modifier.fillMaxSize()) {

        backgroundImage?.let {
            Image(
                bitmap = backgroundImage,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Box(modifier = Modifier.fillMaxSize().background(color = Color.Black.copy(alpha = 0.4f)))

        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(fraction = 0.8f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            val logo = loadVectorResource(id = R.drawable.ic_travel_logo).resource.resource

            Box(
                modifier = Modifier
                    .height(185.dp).width(86.dp)
            ) {
                logo?.let {
                    Image(
                        imageVector = it,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            Text(
                text = "Travelouge",
                style = typography.h4.copy(color = Color.White)
            )

        }

        Button(
            modifier = Modifier
                .padding(bottom = 44.dp, start = 16.dp, end = 16.dp)
                .height(44.dp)
                .align(alignment = Alignment.BottomCenter)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = null,
            onClick = {

            }) {
            Text(
                text = "Get Started", modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                style = typography.button.copy(color = Color.White)
            )
        }

    }

}