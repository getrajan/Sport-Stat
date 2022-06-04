package com.Sport.Stat.domain.repository

import com.Sport.Stat.data.remote.MatchDto.MatchDto
import com.Sport.Stat.data.remote.TeamSquadDto.TeamSquadDto

interface AppRepository {

    suspend fun getMatches(): MatchDto

    suspend fun getTeamSquad(teamId: String): TeamSquadDto
}