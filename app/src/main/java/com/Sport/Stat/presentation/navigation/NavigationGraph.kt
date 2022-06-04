package com.Sport.Stat.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.Sport.Stat.presentation.Screen
import com.Sport.Stat.presentation.match.MatchScreen
import com.Sport.Stat.presentation.match.MatchViewModel
import com.Sport.Stat.presentation.matches.MatchesScreen
import com.Sport.Stat.presentation.player.PlayerScreen
import com.Sport.Stat.presentation.player.PlayerViewModel
import com.Sport.Stat.presentation.splash.SplashScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    val matchViewModel: MatchViewModel = hiltViewModel()
    val playerViewModel: PlayerViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.MatchesScreen.route) {
            MatchesScreen(navController, matchViewModel = matchViewModel)
        }
        composable(route = Screen.MatchScreen.route) {
            MatchScreen(navController, matchViewModel, playerViewModel)
        }
        composable(route = Screen.PlayerScreen.route) {
            PlayerScreen(navController = navController, playerViewModel)
        }
    }

}