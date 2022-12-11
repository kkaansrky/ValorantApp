package com.kkaansrky.valorantapp.ui.agent.agentdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkaansrky.valorantapp.data.model.agent.AgentResponse
import com.kkaansrky.valorantapp.domain.usecase.agent.GetAgentUseCase
import com.kkaansrky.valorantapp.util.Constants
import com.kkaansrky.valorantapp.util.Constants.APP_LANGUAGE
import com.kkaansrky.valorantapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val getAgentUseCase: GetAgentUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow<AgentDetailUiState>(AgentDetailUiState.Loading)
    val uiState: StateFlow<AgentDetailUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = AgentDetailUiState.Loading
            savedStateHandle.get<String>(Constants.PARAM_AGENT_UID)?.let { agentUID ->
                val params = GetAgentUseCase.Params(agentUID, APP_LANGUAGE)
                getAgentUseCase.invoke(params).collect { resource ->
                    _uiState.value = when (resource.status) {
                        Resource.Status.SUCCESS -> {
                            if (resource.data != null) {
                                AgentDetailUiState.Success(resource.data)
                            } else {
                                AgentDetailUiState.Error("Something went wrong")
                            }

                        }
                        Resource.Status.ERROR -> AgentDetailUiState.Error(resource.message)
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
