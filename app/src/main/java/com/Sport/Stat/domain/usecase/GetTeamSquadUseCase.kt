package com.Sport.Stat.domain.usecase

import com.Sport.Stat.common.Resource
import com.Sport.Stat.data.remote.TeamSquadDto.toSquad
import com.Sport.Stat.domain.model.SquadMember
import com.Sport.Stat.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamSquadUseCase @Inject constructor(private val appRepository: AppRepository) {
    operator fun invoke(teamId: String): Flow<Resource<List<SquadMember>>> = flow {
        try {
            emit(Resource.Loading<List<SquadMember>>())
            val teamSquadResponse = appRepository.getTeamSquad(teamId = teamId)
            val squadList = teamSquadResponse.results.map { it.toSquad() }
            emit(Resource.Success<List<SquadMember>>(data = squadList))
        } catch (e: HttpException) {
            emit(Resource.Error<List<SquadMember>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<SquadMember>>("Could not reach server. Check your internet connection"))
        }
    }
}