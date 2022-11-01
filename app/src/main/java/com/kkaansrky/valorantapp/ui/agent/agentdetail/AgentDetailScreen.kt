package com.kkaansrky.valorantapp.ui.agent.agentdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.kkaansrky.valorantapp.data.entities.AgentResponse
import com.kkaansrky.valorantapp.ui.status.ShowError
import com.kkaansrky.valorantapp.ui.status.ShowLoading
import com.kkaansrky.valorantapp.ui.theme.Mojo
import com.kkaansrky.valorantapp.ui.theme.RadicalRed

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
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Mojo)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            ShowAgentImage(background = background, fullPortrait = fullPortrait)
            ShowAgentSpecs(displayName = displayName, developerName = developerName)
        }
    }
}

@Composable
private fun ShowAgentSpecs(displayName: String, developerName: String) {
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

@Composable
private fun ShowAgentImage(background: String, fullPortrait: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(RadicalRed)
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
}
