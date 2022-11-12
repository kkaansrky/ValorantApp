package com.kkaansrky.valorantapp.ui.agent.agentdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.kkaansrky.valorantapp.R
import com.kkaansrky.valorantapp.data.entities.Ability
import com.kkaansrky.valorantapp.ui.theme.CocoaBean

val verticalPadding = 0.dp
val horizontalPadding = 8.dp

@Composable
fun ShowAgentText(text: String) {
    Text(
        text = text,
        color = Color.White,
        modifier = Modifier.padding(horizontalPadding)
    )

}

@Composable
fun ShowAgentHeader(header: String) {
    Text(
        text = header,
        color = CocoaBean,
        fontSize = 32.sp,
        modifier = Modifier.padding(horizontalPadding)
    )
}

@Composable
fun ShowAgentAbilities(abilities: List<Ability>) {
    ShowAgentHeader(header = stringResource(R.string.abilities))
    for (item in abilities) {
        ShowAgentAbility(abilityName = item.displayName)
    }
}

@Composable
fun ShowAgentAbility(abilityName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = horizontalPadding
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "• ",
            color = CocoaBean,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                horizontal = horizontalPadding,
                vertical = verticalPadding
            ),
            fontSize = 32.sp
        )
        Text(
            text = abilityName,
            color = Color.White,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ShowAgentImage(background: String, fullPortrait: String, imageHeight: Dp) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(imageHeight),
        painter = rememberImagePainter(background),
        contentDescription = null,
    )
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(imageHeight),
        painter = rememberImagePainter(fullPortrait),
        contentDescription = null,
    )
}
