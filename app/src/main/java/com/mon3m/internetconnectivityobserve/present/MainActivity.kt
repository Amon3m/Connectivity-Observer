package com.mon3m.internetconnectivityobserve.present

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mon3m.internetconnectivityobserve.R
import com.mon3m.internetconnectivityobserve.present.view.NetworkStatusFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NetworkStatusFragment())
                .commit()
        }
    }
}