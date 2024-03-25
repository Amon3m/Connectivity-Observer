package com.mon3m.internetconnectivityobserve.domain.usecase

import com.mon3m.internetconnectivityobserve.data.netwrok.ConnectivityObserver
import javax.inject.Inject

class ObserveNetworkStatusUseCase
@Inject constructor(private val connectivityObserver: ConnectivityObserver) {
    fun execute() = connectivityObserver.observe()

}