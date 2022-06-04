package com.Sport.Stat.presentation.matches

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.Sport.Stat.presentation.Screen
import com.Sport.Stat.presentation.match.MatchViewModel
import com.Sport.Stat.presentation.matches.components.ItemMatch
import com.Sport.Stat.presentation.ui.theme.CustomTypography
import com.Sport.Stat.presentation.ui.theme.GrayLightColor


@Composable
fun MatchesScreen(
    navController: NavController,
    matchesViewModel: MatchesViewModel = hiltViewModel(),
    matchViewModel: MatchViewModel
) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Matches",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = CustomTypography.appBarTitleStyle
                )
            },
            backgroundColor = GrayLightColor,
        )
    }) { innerPadding ->
        val state = matchesViewModel.state.value
        Box(modifier = Modifier.fillMaxSize()) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.matchList.size) { index ->
                    val match = state.matchList[index]
                    ItemMatch(
                        match = match,
                        onItemClick = {
//                            navController.currentBackStackEntry?.savedStateHandle?.set(
//                                key = "match",
//                                value = match
//                            )
                            matchViewModel.setNavigatedMatch(match = match)
                            navController.navigate(Screen.MatchScreen.route)
                        },
                        bgColor = if (index % 2 == 1) Color(0xFFF6F6F6) else Color(0xFFFCFCFC)
                    )
                }
            }
        }
    }

}

