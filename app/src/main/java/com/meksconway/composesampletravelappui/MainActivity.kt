package com.meksconway.composesampletravelappui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meksconway.composesampletravelappui.ScreenState.*
import com.meksconway.composesampletravelappui.pages.HomePage
import com.meksconway.composesampletravelappui.pages.OnBoardingPage
import com.meksconway.composesampletravelappui.ui.ComposeSampleTravelAppUITheme

enum class ScreenState {
    ON_BOARDING, DEFAULT
}

class MainViewModel: ViewModel() {

    val screenState = MutableLiveData<ScreenState>()



}

class MainActivity : AppCompatActivity() {


    private val viewModel by viewModels<MainViewModel>()

    private fun setLightStatusBar() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.statusBarColor = Color.WHITE
            }
        }
    }

    private fun setFullScreen() {
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
        setFullScreen()
        setContent {
            ComposeSampleTravelAppUITheme {
                Surface(color = MaterialTheme.colors.background) {
                    //OnBoardingPage()
                    HomePage()
                }
            }
        }
    }

    private fun observeViewModel() {
        viewModel.screenState.observe(this) {
            it ?: return@observe
            when(it) {
                ON_BOARDING -> setFullScreen()
                DEFAULT -> setLightStatusBar()
            }
        }
    }
}

