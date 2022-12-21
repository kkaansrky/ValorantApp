package com.kkaansrky.valorantapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kkaansrky.valorantapp.ui.agent.agentdetail.AgentDetailScreen
import com.kkaansrky.valorantapp.ui.agent.listagents.AgentsListScreen
import com.kkaansrky.valorantapp.ui.maps.MapsScreen
import com.kkaansrky.valorantapp.ui.theme.CocoaBean
import com.kkaansrky.valorantapp.ui.theme.Mojo
import com.kkaansrky.valorantapp.ui.theme.ValorantAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantAppTheme {
                val navController = rememberNavController()

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(CocoaBean)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AgentsListScreen.route,
                        modifier = Modifier.padding(bottom = 50.dp)
                    ) {
                        composable(
                            route = Screen.AgentsListScreen.route
                        ) {
                            AgentsListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AgentDetailScreen.route + "/{agentUID}"
                        ) {
                            AgentDetailScreen(navController = navController)
                        }
                        composable(
                            route = Screen.MapsScreen.route
                        ) {
                            MapsScreen(navController = navController)
                        }
                    }
                    SetFooter(navController, Modifier.align(Alignment.BottomCenter))
                }
            }
        }
    }

    /**
     * 1 -> AgentListScreen
     * 2 -> MapsScreen
     */
    private val _buttonState = MutableStateFlow(1)
    private val buttonState: StateFlow<Int> = _buttonState

    @Composable
    private fun SetFooter(navController: NavHostController, modifier: Modifier) {
        Box(
            modifier = modifier.fillMaxWidth()
                .background(Mojo)
        ) {
            Row(
                Modifier.fillMaxWidth()
            ) {
                val stateValue = buttonState.collectAsState().value

                Button(
                    onClick = {
                        navController.navigate(Screen.AgentsListScreen.route)
                        _buttonState.value = 1
                    },
                    enabled = stateValue != 1
                ) {
                    Text(text = "Agents")
                }

                Button(
                    onClick = {
                        navController.navigate(Screen.MapsScreen.route)
                        _buttonState.value = 2
                    },
                    enabled = stateValue != 2
                ) {
                    Text(text = "Maps")
                }
            }
        }
    }
}
