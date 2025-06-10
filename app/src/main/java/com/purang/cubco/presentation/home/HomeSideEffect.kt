package com.purang.cubco.presentation.home

sealed class HomeSideEffect {
    data class ShowSnackBar(val message: String) : HomeSideEffect()
    data object NavigateUp: HomeSideEffect()
    data object NavigateNext: HomeSideEffect()
}