package com.mon3m.internetconnectivityobserve.present.di

import com.mon3m.internetconnectivityobserve.data.netwrok.NetworkConnectivityObserver
import com.mon3m.internetconnectivityobserve.domain.usecase.ObserveNetworkStatusUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {
    @Provides
    @Singleton
    fun provideCreateCustomerUseCase(networkConnectivityObserver: NetworkConnectivityObserver): ObserveNetworkStatusUseCase {
        return ObserveNetworkStatusUseCase(networkConnectivityObserver)
    }

}