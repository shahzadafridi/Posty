package com.realtime.realtimeblogs.ui.theme.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.realtime.realtimeblogs.R
import com.realtime.realtimeblogs.ui.theme.BorderColor
import com.realtime.realtimeblogs.ui.theme.RoundRectShape


@Composable
fun PostCard(){
    Card(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .padding(vertical = 16.dp, horizontal = 8.dp),
        border = BorderStroke(0.5.dp, BorderColor),
        elevation = 1.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 14.dp, horizontal = 8.dp)
        ) {
            PostHeaderSection()
            Spacer(modifier = Modifier.padding(top = 16.dp))
            PostContentSection()
            Spacer(modifier = Modifier.padding(top = 16.dp))
            PostFooterSection()
        }

    }
}


@Composable
fun PostHeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(40.dp, 40.dp)
                .clip(RoundRectShape.small)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = "Title",
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = "Headline",
                style = MaterialTheme.typography.caption
            )
        }
    }
}


@Composable
fun PostContentSection() {
    Surface {
        Column {
            Text(
                text = "Khar said the development spoke volumes about the comprehensive reforms carried out in Pakistan...",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Consequent to the fruitful discussions held at the plenary, the FATF has decided by consensus that Pakistan has addressed all technical benchmarks and completed all ... action plans - 2018 and 2021.",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(top = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .height(190.dp)
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun PostFooterSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            /** Favourite Icon */
            IconToggleButton(
                modifier = Modifier.
                then(Modifier.size(24.dp)),
                checked = false,
                onCheckedChange = {}
            ) {
                Icon(
                    imageVector = if (true) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = null
                )
            }
            Text(
                text = "13",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp)
            )
            /** Comment Icon */
            Icon(
                imageVector = Icons.Filled.ThumbUp,
                contentDescription = null,
                modifier = Modifier.padding(start = 25.dp)
            )
            Text(
                text = "12",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        /** Share Icon */
        Icon(
            imageVector = Icons.Filled.Share,
            contentDescription = null,
            modifier = Modifier.padding(start = 25.dp)
        )
    }
}
