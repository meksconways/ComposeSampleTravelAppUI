package com.meksconway.composesampletravelappui.navigation

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.android.parcel.Parcelize

sealed class Destination : Parcelable {
    @Parcelize
    object Home : Destination()

    @Parcelize
    object OnBoarding: Destination()

    @Immutable
    @Parcelize
    data class SnackDetail(val snackId: Long) : Destination()
}


class Actions(navigator: Navigator<Destination>) {

    val selectSnack: (Long) -> Unit = { snackId: Long ->
        navigator.navigate(Destination.SnackDetail(snackId))
    }

    val upPress: () -> Unit = {
        navigator.back()
    }

    val actionHome: () -> Unit = {
        navigator.navigate(Destination.Home)
    }
}