package com.Sport.Stat.domain.usecase

import android.util.Log
import com.Sport.Stat.common.Resource
import com.Sport.Stat.data.remote.MatchDto.toMatchModel
import com.Sport.Stat.domain.model.MatchModel
import com.Sport.Stat.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(
    private val appRepository: AppRepository
) {
    operator fun invoke(): Flow<Resource<List<MatchModel>>> = flow {
        try {
            emit(Resource.Loading<List<MatchModel>>())
            val matchesResponse = appRepository.getMatches()
            val matchList = matchesResponse.games_pre.map { it.toMatchModel() }
            emit(Resource.Success<List<MatchModel>>(data = matchList))
        } catch (e: HttpException) {
            emit(Resource.Error<List<MatchModel>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            Log.d("TAG", "invoke: ${e.message}")
            emit(Resource.Error<List<MatchModel>>("Could not reach server. Check your internet connection"))
        }
    }
}