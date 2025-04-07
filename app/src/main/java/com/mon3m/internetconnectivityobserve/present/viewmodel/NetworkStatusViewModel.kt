package com.mon3m.internetconnectivityobserve.present.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mon3m.internetconnectivityobserve.data.netwrok.ConnectivityObserver
import com.mon3m.internetconnectivityobserve.domain.usecase.ObserveNetworkStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NetworkStatusViewModel @Inject constructor(
    private val connectivityObserver: ConnectivityObserver
) : ViewModel() {
    private val _networkStatus = MutableSharedFlow<ConnectivityObserver.NetworkStatus>(
        replay = 0,
        extraBufferCapacity = 1
    )
    val networkStatus: SharedFlow<ConnectivityObserver.NetworkStatus> = _networkStatus

    init {
        viewModelScope.launch {
            var isFirstEmission = true

            connectivityObserver.observe()
                .transform { status ->
                    if (isFirstEmission) {
                        isFirstEmission = false
                        // Skip the first emission if it's Available
                        if (status == ConnectivityObserver.NetworkStatus.Available) return@transform
                    }
                    emit(status)
                }
                .debounce(3000)
                .collectLatest { status ->
                    _networkStatus.emit(status)
                }
        }
    }
}