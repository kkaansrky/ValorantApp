package com.kkaansrky.valorantapp.ui.listagents

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkaansrky.valorantapp.data.entities.AgentResponse
import com.kkaansrky.valorantapp.data.repository.ApiRepository
import com.kkaansrky.valorantapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsListViewModel @Inject constructor(
    private var apiRepository: ApiRepository
) : ViewModel() {

    val appLanguage = "tr-TR"
    val isPlayable = true

    private val _uiState = MutableStateFlow<AgentsUiState>(AgentsUiState.Success(emptyList()))
    val uiState: StateFlow<AgentsUiState> = _uiState

    init {
        viewModelScope.launch {
            apiRepository.getAgents(appLanguage, isPlayable)
                .collect { response ->
                    Log.d(TAG, "viewModelAgentsResponse: " + response)
                    if (response.status == Resource.Status.SUCCESS) {
                        if (response.data != null) {
                            _uiState.value = AgentsUiState.Success(response.data.data)
                        }
                    } else if (response.status == Resource.Status.ERROR) {
                        _uiState.value = AgentsUiState.Error(response.message)
                    } else {
                        _uiState.value = AgentsUiState.Loading
                    }
                }
        }
    }

}

sealed class AgentsUiState {
    data class Success(val agents: List<AgentResponse>) : AgentsUiState()
    data class Error(val exception: String?) : AgentsUiState()
    object Loading : AgentsUiState()
}