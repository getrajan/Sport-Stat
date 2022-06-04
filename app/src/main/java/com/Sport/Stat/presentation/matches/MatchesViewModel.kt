package com.Sport.Stat.presentation.matches

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Sport.Stat.common.Resource
import com.Sport.Stat.domain.usecase.GetMatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    val getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MatchesState())
    val state: State<MatchesState> = _state

    init {
        getMatches()
    }

    private fun getMatches() {
        getMatchesUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MatchesState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = MatchesState(matchList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MatchesState(error = result.message ?: "Unexpected Error Occurs")
                }
            }
        }.launchIn(viewModelScope)
    }
}