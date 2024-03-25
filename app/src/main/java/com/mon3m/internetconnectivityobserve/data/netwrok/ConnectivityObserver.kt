package com.mon3m.internetconnectivityobserve.data.netwrok

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observe(): Flow<NetworkStatus>

    enum class NetworkStatus {
        Available,Unavailable,Losing,Lost
    }
}