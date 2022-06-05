package com.Sport.Stat.domain.usecase

import com.Sport.Stat.common.Resource
import com.Sport.Stat.data.remote.MoreInfoDto.toPlayerInfo
import com.Sport.Stat.domain.model.PlayerInfo
import com.Sport.Stat.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMoreInfoUseCase @Inject constructor(
    private val appRepository: AppRepository
) {
    operator fun invoke(playerId: String): Flow<Resource<List<PlayerInfo>>> = flow {
        try {
            emit(Resource.Loading<List<PlayerInfo>>())
            val moreInfoResponse = appRepository.getPlayerMoreInfo(playerId)
            val playerInfoList = moreInfoResponse.results.events.map { it.toPlayerInfo() }
            emit(Resource.Success<List<PlayerInfo>>(data = playerInfoList))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<PlayerInfo>>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<PlayerInfo>>("Could not reach server. Check your internet connection"))
        }
    }
}