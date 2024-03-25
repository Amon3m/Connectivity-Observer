package com.mon3m.internetconnectivityobserve.present.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mon3m.internetconnectivityobserve.data.netwrok.ConnectivityObserver
import com.mon3m.internetconnectivityobserve.domain.usecase.ObserveNetworkStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NetworkStatusViewModel @Inject constructor(
    private val observeNetworkStatusUseCase: ObserveNetworkStatusUseCase

): ViewModel(){
    private val _networkStatus = MutableStateFlow<ConnectivityObserver.NetworkStatus>(
        ConnectivityObserver.NetworkStatus.Unavailable)
    val networkStatus: StateFlow<ConnectivityObserver.NetworkStatus> get() = _networkStatus

    init {
        viewModelScope.launch {
            observeNetworkStatusUseCase.execute().collect { status ->
                _networkStatus.value = status
            }
        }
    }
}