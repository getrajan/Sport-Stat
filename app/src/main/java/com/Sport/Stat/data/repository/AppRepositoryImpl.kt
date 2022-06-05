package com.Sport.Stat.data.repository

import com.Sport.Stat.common.Constants.login
import com.Sport.Stat.common.Constants.token
import com.Sport.Stat.data.remote.MatchDto.MatchDto
import com.Sport.Stat.data.remote.MoreInfoDto.MoreInfoDto
import com.Sport.Stat.data.remote.SportStatApi
import com.Sport.Stat.data.remote.TeamSquadDto.TeamSquadDto
import com.Sport.Stat.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val api: SportStatApi
) : AppRepository {
    override suspend fun getMatches(): MatchDto {
        return api.getMatches()
    }

    override suspend fun getTeamSquad(teamId: String): TeamSquadDto {
        return api.getTeamSquad(
            login = login,
            token = token,
            task = "squaddata",
            team = teamId
        )
    }

    override suspend fun getPlayerMoreInfo(playerId: String): MoreInfoDto {
        return api.getPlayerMoreInfo(
            login = login,
            token = token,
            task = "playerdata",
            player = playerId
        )
    }
}