package com.kkaansrky.valorantapp.ui.agent.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.kkaansrky.valorantapp.data.entities.Agent
import com.kkaansrky.valorantapp.ui.theme.Mojo
import com.kkaansrky.valorantapp.ui.theme.RadicalRed

@Composable
fun AgentListItem(
    agent: Agent,
    onItemClick: (Agent) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Mojo
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp)
                .clickable { onItemClick(agent) },
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            ShowListAgentItemImage(background = agent.background, fullPortrait = agent.fullPortrait)

            Text(
                text = agent.displayName,
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
private fun ShowListAgentItemImage(background:String, fullPortrait: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp)
            .background(RadicalRed)
    ) {
        Image(
            painter = rememberImagePainter(background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = rememberImagePainter(fullPortrait),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
    }
}