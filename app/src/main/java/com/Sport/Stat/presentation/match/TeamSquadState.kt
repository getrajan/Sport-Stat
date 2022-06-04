package com.Sport.Stat.presentation.match

import com.Sport.Stat.domain.model.SquadMember

data class TeamSquadState(
    val isLoading: Boolean = false,
    val squadMemberList: List<SquadMember> = emptyList(),
    val error: String = ""
)