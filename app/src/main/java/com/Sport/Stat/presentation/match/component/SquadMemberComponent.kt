package com.Sport.Stat.presentation.match.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Sport.Stat.presentation.Screen
import com.Sport.Stat.presentation.match.MatchViewModel
import com.Sport.Stat.presentation.player.PlayerViewModel
import com.Sport.Stat.presentation.ui.theme.CustomTypography
import com.Sport.Stat.presentation.ui.theme.GrayColor

@Composable
fun SquadMemberComponent(
    matchViewModel: MatchViewModel,
    navController: NavController,
    playerViewModel: PlayerViewModel
) {
    val squadState = matchViewModel.squadMemberListState.value
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            squadState.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            squadState.error.isNotBlank() -> {
                Text(
                    text = squadState.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            else -> {
                if (squadState.squadMemberList.isEmpty()) {
                    Text(
                        text = "No Team Squad Members",
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(squadState.squadMemberList) { squadMember ->
                        Box(modifier = Modifier
                            .border(BorderStroke(1.dp, GrayColor))
                            .clickable {
                                playerViewModel.setPlayer(squadMember)
                                navController.navigate(Screen.PlayerScreen.route)
                            }
                        ) {
                            Text(
                                text = squadMember.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                style = CustomTypography.playerNameStyle,
                            )
                        }
                    }
                }
            }
        }
    }
}