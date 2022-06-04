package com.Sport.Stat.presentation.matches.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.Sport.Stat.common.MyDateTimeFormat
import com.Sport.Stat.domain.model.MatchModel
import com.Sport.Stat.presentation.ui.theme.TealColor

@Composable
fun ItemMatch(
    match: MatchModel,
    onItemClick: (MatchModel) -> Unit,
    bgColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = bgColor)
            .padding(16.dp)
            .clickable { onItemClick(match) }
    ) {
        Column {
            Text(text = match.league.name, style = MaterialTheme.typography.subtitle1)
            Row {
                Text(
                    text = MyDateTimeFormat.timeFormat(match.time.toLong() * 1000),
                    style = MaterialTheme.typography.subtitle1
                        .copy(color = TealColor)
                )
                Text(
                    text = MyDateTimeFormat.dateFormat(match.time.toLong() * 1000),
                    style = MaterialTheme.typography.body1
                        .copy(color = TealColor),
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
            Box(modifier = Modifier.height(16.dp))
            Text(
                text = match.home.name, style = MaterialTheme.typography.h2
            )
            Text(
                text = match.away.name, style = MaterialTheme.typography.h2
            )
        }
    }
}