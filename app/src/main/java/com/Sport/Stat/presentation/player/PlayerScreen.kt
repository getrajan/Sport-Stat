package com.Sport.Stat.presentation.player

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Sport.Stat.R
import com.Sport.Stat.common.Constants
import com.Sport.Stat.domain.model.SquadMember
import com.Sport.Stat.presentation.player.component.PlayerScreenAppBar
import com.Sport.Stat.presentation.ui.theme.CustomTypography
import com.Sport.Stat.presentation.ui.theme.RedColor
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun PlayerScreen(navController: NavController, playerViewModel: PlayerViewModel) {
    Scaffold(
        topBar = {
            PlayerScreenAppBar(navController = navController)
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 18.dp, horizontal = 40.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(RedColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "More Info",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1.copy(color = Color.White)
                )
            }
        }
    ) {
        val player: SquadMember? = playerViewModel.player.value

        var detailItemList: ArrayList<String> = arrayListOf()

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        if (player != null) {
            val height =
                if (player.height == Constants.na) player.height else (df.format((player.height.toDouble() / 100))).toString()
            detailItemList.add("Date birthday: ${player.birthdate}")
            detailItemList.add("Position: ${player.position}")
            detailItemList.add("Height: $height m")
            detailItemList.add("Weight: ${player.weight} kg")
            detailItemList.add("Main Leg: ${player.foot}")
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn() {
                    item {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_photo),
                                contentDescription = "Player Photo",
                                modifier = Modifier
                                    .height(65.dp)
                                    .width(76.dp),
                                contentScale = ContentScale.Fit
                            )
                            Text(
                                text = player.name,
                                modifier = Modifier.padding(10.dp),
                                style = CustomTypography.teamNameStyle
                            )
                        }
                    }
                    items(detailItemList) { item ->
                        Column {
                            Box(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = item,
                                    modifier = Modifier.padding(12.dp),
                                    style = CustomTypography.playerNameStyle,
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color(0xFFBBBBBB))
                            )
                        }
                    }
                }
            }
        }

    }
}


