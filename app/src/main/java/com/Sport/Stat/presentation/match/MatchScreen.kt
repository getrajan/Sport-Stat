package com.Sport.Stat.presentation.match

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Sport.Stat.domain.model.MatchModel
import com.Sport.Stat.presentation.match.component.*
import com.Sport.Stat.presentation.player.PlayerViewModel

@Composable
fun MatchScreen(
    navController: NavController,
    matchViewModel: MatchViewModel,
    playerViewModel: PlayerViewModel,
) {
    Scaffold(topBar = {
        MatchAppBarComponent(navController = navController)
    }) {
        val match: MatchModel? = matchViewModel.targetedMatch.value
        if (match != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    LeagueInfoComponent(match)
                    TeamsImageComponent(match)
                    Box(modifier = Modifier.height(24.dp))
                    TeamToggleComponent(matchViewModel)
                    Box(modifier = Modifier.height(6.dp))
                    SquadMemberComponent(matchViewModel, navController, playerViewModel)
                }
            }
        }
    }
}











