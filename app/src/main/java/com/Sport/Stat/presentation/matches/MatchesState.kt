package com.Sport.Stat.presentation.matches

import com.Sport.Stat.domain.model.MatchModel

data class MatchesState(
    val isLoading: Boolean = false,
    val matchList: List<MatchModel> = emptyList(),
    val error: String = ""
)
