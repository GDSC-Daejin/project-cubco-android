package com.purang.cubco.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purang.cubco.core.util.UiState
import com.purang.cubco.core.util.handleError
import com.purang.cubco.data.repository.CurationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val curationRepository: CurationRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState>
        get() = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<HomeSideEffect>()
    val sideEffect: MutableSharedFlow<HomeSideEffect>
        get() = _sideEffect

    fun getCurations() = viewModelScope.launch {
        curationRepository.getCurations(
            page = 0,
            size = 10
        ).onSuccess {
            _state.value = _state.value.copy(
                uiState = UiState.Success(it.curations.toPersistentList())
            )
        }.onFailure { throwable ->
            val errorMessage = handleError(throwable)
            _state.value = _state.value.copy(
                uiState = UiState.Failure(errorMessage)
            )
            showSnackBar(errorMessage)
        }
    }


    fun showSnackBar(message: String) = viewModelScope.launch {
        _sideEffect.emit(HomeSideEffect.ShowSnackBar(message))
    }

    fun navigateUp() = viewModelScope.launch {
        _sideEffect.emit(HomeSideEffect.NavigateUp)
    }

    fun navigateNext() = viewModelScope.launch {
        _sideEffect.emit(HomeSideEffect.NavigateNext)
    }
}