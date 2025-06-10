package com.purang.cubco.presentation.home

import com.purang.cubco.core.util.UiState
import com.purang.cubco.data.models.CurationEntity
import kotlinx.collections.immutable.PersistentList

data class HomeState (
    val uiState: UiState<PersistentList<CurationEntity>> = UiState.Loading,
//    val chattingState : UiState<String> = UiState.Loading, //response로 받을 데이터가 없음. post 메세지 관리용
//    val chattingText : String = "",
//    val isSendChatting : Boolean = false
)