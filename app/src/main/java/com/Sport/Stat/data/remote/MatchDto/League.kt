package com.Sport.Stat.data.remote.MatchDto

import com.Sport.Stat.domain.model.LeagueModel

data class League(
    val cc: String,
    val id: String,
    val name: String
)

fun League.toLeagueModel(): LeagueModel {
    return LeagueModel(
        cc = cc,
        id = id,
        name = name
    );
}