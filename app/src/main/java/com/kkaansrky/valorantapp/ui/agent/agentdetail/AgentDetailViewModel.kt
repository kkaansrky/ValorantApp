package com.kkaansrky.valorantapp.ui.agent.agentdetail


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deliveryhero.whetstone.viewmodel.ContributesViewModel
import com.kkaansrky.valorantapp.data.entities.AgentResponse
import com.kkaansrky.valorantapp.data.repository.ApiRepository
import com.kkaansrky.valorantapp.util.Constants
import com.kkaansrky.valorantapp.util.Constants.APP_LANGUAGE
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ContributesViewModel
class AgentDetailViewModel @Inject constructor(
    apiRepository: ApiRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow<AgentDetailUiState>(AgentDetailUiState.Loading)
    val uiState: StateFlow<AgentDetailUiState> = _uiState

    init {
        viewModelScope.launch {
            savedStateHandle.get<String>(Constants.PARAM_AGENT_UID)?.let { agentUID ->
                apiRepository.getAgentByUID(agentUID, APP_LANGUAGE).collect { response ->
                    _uiState.value = when (response.status) {
                        Resource.Status.SUCCESS -> AgentDetailUiState.Success(response.data!!)
                        Resource.Status.ERROR -> AgentDetailUiState.Error(response.message)
                        else -> AgentDetailUiState.Loading
                    }
                }
            }
        }
    }
}

sealed class AgentDetailUiState {
    data class Success(val agent: AgentResponse) : AgentDetailUiState()
    data class Error(val exception: String?) : AgentDetailUiState()
    object Loading : AgentDetailUiState()
}
