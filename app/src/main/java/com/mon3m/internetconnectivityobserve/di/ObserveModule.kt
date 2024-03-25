package com.mon3m.internetconnectivityobserve.di

import com.mon3m.internetconnectivityobserve.data.netwrok.ConnectivityObserver
import com.mon3m.internetconnectivityobserve.data.netwrok.NetworkConnectivityObserver
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class ObserveModule {
    @Binds
    @ViewModelScoped
    abstract fun bindNetworkConnectivityObserver(networkConnectivityObserver: NetworkConnectivityObserver)
    : ConnectivityObserver

}