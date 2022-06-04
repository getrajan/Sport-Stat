package com.Sport.Stat.presentation.player

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Sport.Stat.domain.model.SquadMember
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlayerViewModel @Inject constructor() : ViewModel() {

    private val _nPlayer = mutableStateOf<SquadMember?>(null)
    val player: State<SquadMember?> = _nPlayer

    fun setPlayer(player: SquadMember) {
        viewModelScope.launch {
            _nPlayer.value = player
        }
    }
}