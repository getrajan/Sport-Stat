package com.Sport.Stat.presentation.more_info

import com.Sport.Stat.domain.model.PlayerInfo

data class MoreInfoState(
    val isLoading: Boolean = false,
    val infoList: List<PlayerInfo> = emptyList(),
    val error: String = ""
)