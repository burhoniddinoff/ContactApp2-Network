package com.example.contactappwithinternet2.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest

class NetworkStatusValidator private constructor() {

    companion object {

        var hasNetwork: Boolean = false
        private lateinit var instance: NetworkStatusValidator

        fun init(context: Context, availableNetwork: () -> Unit) {

            if (!(::instance.isInitialized)) instance = NetworkStatusValidator()

            val networkRequest =
                NetworkRequest.Builder().addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                    .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR).build()

            val connectivityCallBack = object : ConnectivityManager.NetworkCallback() {

                override fun onAvailable(network: Network) {
                    super.onAvailable(network)

                    availableNetwork.invoke()
                    hasNetwork = true

                }

                override fun onLost(network: Network) {
                    super.onLost(network)

                    hasNetwork = false
                }

            }

            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            connectivityManager.requestNetwork(networkRequest, connectivityCallBack)

        }

        fun getInstance() = instance

    }

}