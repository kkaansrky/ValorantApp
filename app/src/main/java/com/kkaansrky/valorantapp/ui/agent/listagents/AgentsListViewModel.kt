package com.kkaansrky.valorantapp.ui.agent.listagents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkaansrky.valorantapp.data.entities.Agent
import com.kkaansrky.valorantapp.data.repository.ApiRepository
import com.kkaansrky.valorantapp.util.Constants.APP_LANGUAGE
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AgentsListViewModel @Inject constructor(
    private var apiRepository: ApiRepository
) : ViewModel() {

    val isPlayable = true

    private val _uiState = MutableStateFlow<AgentListUiState>(AgentListUiState.Success(emptyList()))
    val uiState: StateFlow<AgentListUiState> = _uiState

    init {
        viewModelScope.launch {
            apiRepository.getAgents(APP_LANGUAGE, isPlayable)
                .collect { response ->
                    _uiState.value = when (response.status) {
                        Resource.Status.SUCCESS -> AgentListUiState.Success(response.data!!.data)
                        Resource.Status.ERROR -> AgentListUiState.Error(response.message)
                        else -> AgentListUiState.Loading
                    }
                }
        }
    }

}

sealed class AgentListUiState {
    data class Success(val agents: List<Agent>) : AgentListUiState()
    data class Error(val exception: String?) : AgentListUiState()
    object Loading : AgentListUiState()
}