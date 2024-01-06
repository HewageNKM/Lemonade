package com.example.lemonade

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LemonadeViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow(UiState(R.drawable.lemon_tree, "Tap the lemon tree to select a lemon"))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private var state by mutableIntStateOf(1)
    private var subState by mutableIntStateOf(0)

    fun ChangeTheState() {
        if (state == 4) {
            state = 1
            subState = 0
        } else if (state == 2) {
            if (subState == 3) {
                state++
                subState = 0
            } else {
                subState++
            }
        } else if (state != 2) {
            state++
        }

        _uiState.update { uiState ->
            uiState.copy(
                imageResource = when (state) {
                    1 -> R.drawable.lemon_tree
                    2 -> R.drawable.lemon_squeeze
                    3 -> R.drawable.lemon_drink
                    else -> R.drawable.lemon_restart
                },
                text = when (state) {
                    1 -> "Tap the lemon tree to select a lemon"
                    2 -> "Keep tapping the lemon to squeeze it"
                    3 -> "Tap the lemon to drink it"
                    else -> "Tap the empty glass to start again"
                }
            )
        }
    }
}


