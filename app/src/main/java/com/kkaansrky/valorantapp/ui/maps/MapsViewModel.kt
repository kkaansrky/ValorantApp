package com.kkaansrky.valorantapp.ui.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkaansrky.valorantapp.data.model.map.MapDto
import com.kkaansrky.valorantapp.domain.usecase.map.GetMapsUseCase
import com.kkaansrky.valorantapp.util.Constants
import com.kkaansrky.valorantapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    getMapsUseCase: GetMapsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<MapsUiState>(MapsUiState.Loading)
    val uiState: StateFlow<MapsUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = MapsUiState.Loading
            val params = GetMapsUseCase.Params(Constants.APP_LANGUAGE)
            getMapsUseCase(params).collect { resource ->
                _uiState.value = when (resource.status) {
                    Resource.Status.SUCCESS ->{
                        if (resource.data?.data != null) {
                            MapsUiState.Success(resource.data.data)
                        }else {
                            MapsUiState.Error("Something went wrong")
                        }
                    }

                    Resource.Status.ERROR -> MapsUiState.Error(resource.message)
                    else -> MapsUiState.Loading
                }
            }
        }
    }
}

sealed class MapsUiState {
    data class Success(val maps: List<MapDto>) : MapsUiState()
    data class Error(val exception: String?) : MapsUiState()
    object Loading : MapsUiState()
}