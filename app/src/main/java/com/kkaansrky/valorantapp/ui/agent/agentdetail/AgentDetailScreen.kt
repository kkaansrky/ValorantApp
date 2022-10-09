package com.kkaansrky.valorantapp.ui.agent.agentdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.kkaansrky.valorantapp.data.entities.AgentResponse
import com.kkaansrky.valorantapp.ui.status.ShowError
import com.kkaansrky.valorantapp.ui.status.ShowLoading

@Composable
fun AgentDetailScreen(
    navController: NavController,
    agentDetailViewModel: AgentDetailViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val state = agentDetailViewModel.uiState.collectAsState().value

        when (state) {
            is AgentDetailUiState.Loading -> ShowLoading()
            is AgentDetailUiState.Success -> ShowAgent(state.agent)
            is AgentDetailUiState.Error -> ShowError()
        }
    }
}

@Composable
fun ShowAgent(agent: AgentResponse) = with(agent.data) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp)
            .background(Color.Red),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp)
        ) {
            Image(
                painter = rememberImagePainter(background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = rememberImagePainter(fullPortrait),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }


        Text(
            text = displayName,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = developerName,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}
