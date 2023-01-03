package com.kkaansrky.valorantapp.ui.maps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.kkaansrky.valorantapp.data.model.map.MapDto
import com.kkaansrky.valorantapp.ui.theme.Mojo
import com.kkaansrky.valorantapp.ui.theme.RadicalRed

@Composable
fun MapsListItem(map: MapDto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Mojo
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp),
                //.clickable { onItemClick(map) }
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            ShowMapItemImage(listViewIcon = map.listViewIcon)

            Text(
                text = map.displayName,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ShowMapItemImage(listViewIcon: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp)
            .background(RadicalRed)
    ) {
        Image(
            painter = rememberImagePainter(listViewIcon),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp),
            contentScale = ContentScale.FillWidth
        )
    }
}
