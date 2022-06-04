package com.Sport.Stat.presentation.match.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.Sport.Stat.presentation.match.MatchViewModel
import com.Sport.Stat.presentation.match.TeamEnum
import com.Sport.Stat.presentation.ui.theme.GrayColor
import com.Sport.Stat.presentation.ui.theme.GrayLightColor
import com.Sport.Stat.presentation.ui.theme.TealColor

@Composable
fun TeamToggleComponent(matchViewModel: MatchViewModel) {
    val teamState = matchViewModel.teamState.value
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        matchViewModel.toggleTeams(TeamEnum.TEAM1)
                    }
            ) {
                Box(
                    modifier = Modifier
                        .background(if (teamState == TeamEnum.TEAM1) TealColor else GrayLightColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Team 1",
                        modifier = Modifier.padding(vertical = 10.dp),
                        color = if (teamState == TeamEnum.TEAM1) Color.White else GrayColor,
                        style = MaterialTheme.typography.body1
                    )
                }
            }
            Box(modifier = Modifier.width(12.dp))
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        matchViewModel.toggleTeams(TeamEnum.TEAM2)
                    }
            ) {
                Box(
                    modifier = Modifier
                        .background(if (teamState == TeamEnum.TEAM2) TealColor else GrayLightColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Team 2",
                        modifier = Modifier.padding(vertical = 10.dp),
                        color = if (teamState == TeamEnum.TEAM2) Color.White else GrayColor,
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}