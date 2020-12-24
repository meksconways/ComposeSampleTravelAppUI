package com.meksconway.composesampletravelappui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.meksconway.composesampletravelappui.MainViewModel
import com.meksconway.composesampletravelappui.R
import com.meksconway.composesampletravelappui.ScreenState
import com.meksconway.composesampletravelappui.ui.typography


@Composable
fun HomePage() {

    val mainViewModel: MainViewModel = viewModel()
    mainViewModel.screenState.value = ScreenState.DEFAULT

    Column(modifier = Modifier.fillMaxSize()) {
        HomePageNavBar()
        HomePageTitle()
        ExploreTabLayout()
    }

}

@Composable
fun HomePageNavBar() {
    ConstraintLayout(Modifier.fillMaxWidth().padding(16.dp)) {
        val (boxText, boxImage) = createRefs()

        Text(
            text = "Welcome Susan",
            style = typography.subtitle1.copy(
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.constrainAs(boxText) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                linkTo(
                    startMargin = 0.dp,
                    endMargin = 16.dp,
                    start = parent.start,
                    end = boxImage.start,
                    bias = 0F
                )

            }
        )

        Box(
            modifier = Modifier.size(44.dp).background(
                color = Color.LightGray,
                shape = CircleShape
            )
                .constrainAs(boxImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        ) {
            val image = loadImageResource(id = R.drawable.profile_photo).resource.resource
            image?.let {
                Image(
                    bitmap = image,
                    modifier = Modifier.fillMaxSize().clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

        }
    }
}

@Composable
fun HomePageTitle() {
    Text(
        text = "Explore", modifier = Modifier.padding(
            top = 0.dp, start = 16.dp
        ),
        style = typography.h4.copy(
            fontWeight = FontWeight.Bold
        )
    )
}

enum class AppTabRows(val title: String) {

    Places("Places"),
    Experiences("Experiences"),
    Reviews("Reviews"),

}

@Composable
fun TabIndicator() {
    Box(modifier = Modifier.height(3.dp).background(
        MaterialTheme.colors.primary
    ))
}

@Composable
fun ExploreTabLayout() {



    ScrollableRow {
        Spacer(modifier = Modifier.width(16.dp))
        TabItem(text = "Places") {

        }
        Spacer(modifier = Modifier.width(16.dp))
        TabItem(text = "Experiences") {

        }
        Spacer(modifier = Modifier.width(16.dp))
        TabItem(text = "Reviews") {

        }
        Spacer(modifier = Modifier.width(16.dp))
    }

}

@Composable
fun TabItem(text: String, select: () -> Unit) {
    Button(onClick = select) {
        Text(
            text = text,
            style = typography.body2.copy(
                fontWeight = FontWeight.Bold
            ), color = MaterialTheme.colors.primary
        )
    }

}

@Composable
fun AppTabLayout() {

    var tab = AppTabRows.Places
    val tabTitles = AppTabRows.values().map { it.title }



    ScrollableTabRow(
        selectedTabIndex = 0,
        backgroundColor = MaterialTheme.colors.surface,
        indicator = { pos ->

        }
    ) {
        Tab(
            text = { Text("Places") },
            selected = true,
            onClick = { }
        )
        Tab(
            text = { Text("Experiences") },
            selected = false,
            onClick = { }
        )
        Tab(
            text = { Text("Reviews") },
            selected = false,
            onClick = { }
        )
    }

}