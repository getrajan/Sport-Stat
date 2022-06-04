package com.Sport.Stat.data.remote

import com.Sport.Stat.common.Constants.login
import com.Sport.Stat.common.Constants.token
import com.Sport.Stat.data.remote.MatchDto.MatchDto
import com.Sport.Stat.data.remote.TeamSquadDto.TeamSquadDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SportStatApi {
    @GET("get.php?login=$login&token=$token&task=predata&sport=soccer&day=today")
    suspend fun getMatches(): MatchDto

    @GET("get.php")
    suspend fun getTeamSquad(
        @Query("login") login: String,
        @Query("token") token: String,
        @Query("task") task: String,
        @Query("team") team: String,
        ): TeamSquadDto
}