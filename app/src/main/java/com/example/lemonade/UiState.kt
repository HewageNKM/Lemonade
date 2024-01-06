package com.example.lemonade

import androidx.annotation.DrawableRes

data class UiState (
    @DrawableRes var imageResource: Int,
    var text: String
)