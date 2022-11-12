package com.kkaansrky.valorantapp.ui.agent.listagents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkaansrky.valorantapp.data.entities.agent.AgentDto
import com.kkaansrky.valorantapp.domain.usecase.GetAgentsUseCase
import com.kkaansrky.valorantapp.util.Constants.APP_LANGUAGE
import com.kkaansrky.valorantapp.util.Constants.IS_PLAYABLE
import com.kkaansrky.valorantapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsListViewModel @Inject constructor(
    private val getAgentsUseCase: GetAgentsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<AgentListUiState>(AgentListUiState.Success(emptyList()))
    val uiState: StateFlow<AgentListUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = AgentListUiState.Loading
            val params = GetAgentsUseCase.Params(APP_LANGUAGE, IS_PLAYABLE)
            getAgentsUseCase(params).collect { resource ->
                _uiState.value = when (resource.status) {
                    Resource.Status.SUCCESS ->{
                        if (resource.data?.data != null) {
                            AgentListUiState.Success(resource.data.data)
                        }else {
                            AgentListUiState.Error("Something went wrong")
                        }
                    }

                    Resource.Status.ERROR -> AgentListUiState.Error(resource.message)
                    else -> AgentListUiState.Loading
                }
            }
        }
    }

}

sealed class AgentListUiState {
    data class Success(val agents: List<AgentDto>) : AgentListUiState()
    data class Error(val exception: String?) : AgentListUiState()
    object Loading : AgentListUiState()
}