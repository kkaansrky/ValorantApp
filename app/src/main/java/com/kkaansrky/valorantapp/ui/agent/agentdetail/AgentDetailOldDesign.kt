package com.kkaansrky.valorantapp.ui.agent.agentdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kkaansrky.valorantapp.data.entities.agent.AgentResponse

@Deprecated("Old Design")
@Composable
fun ShowAgent(agent: AgentResponse) = with(agent.data) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        ShowAgentImage(background = background, fullPortrait = fullPortrait, 150.dp)
        ShowAgentSpecs(agent = agent.data)
    }
}
