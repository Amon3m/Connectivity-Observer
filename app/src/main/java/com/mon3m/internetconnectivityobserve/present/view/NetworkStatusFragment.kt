package com.mon3m.internetconnectivityobserve.present.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mon3m.internetconnectivityobserve.data.netwrok.ConnectivityObserver
import com.mon3m.internetconnectivityobserve.R
import com.mon3m.internetconnectivityobserve.databinding.FragmentNetworkStatusBinding
import com.mon3m.internetconnectivityobserve.present.viewmodel.NetworkStatusViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class NetworkStatusFragment : Fragment() {
    private val viewModel: NetworkStatusViewModel by viewModels()
    lateinit var binding: FragmentNetworkStatusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNetworkStatusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.networkStatus.onEach { status ->
            when (status) {
                ConnectivityObserver.NetworkStatus.Available -> {
                    binding.textView.text = getString(R.string.network_available)
                }

                ConnectivityObserver.NetworkStatus.Unavailable -> {
                    binding.textView.text = getString(R.string.network_unavailable)
                }

                ConnectivityObserver.NetworkStatus.Losing -> {
                    binding.textView.text = getString(R.string.network_losing)
                }

                ConnectivityObserver.NetworkStatus.Lost -> {
                    binding.textView.text = getString(R.string.network_lost)
                }
            }
            //new change
        }.launchIn(lifecycleScope)
    }

}