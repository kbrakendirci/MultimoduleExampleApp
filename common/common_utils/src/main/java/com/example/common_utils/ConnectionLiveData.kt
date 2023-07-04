package com.example.common_utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.LiveData

const val minDownSpeed: Int = 1000
const val minUploadSpeed: Int = 800

class ConnectionLiveData(private val context: Context) : LiveData<ConnectionStates>() {
    private lateinit var networkState: ConnectionStates
    private val networkReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val nc = cm.getNetworkCapabilities(cm.activeNetwork)
            val downSpeed = nc?.linkDownstreamBandwidthKbps
            val upSpeed = nc?.linkUpstreamBandwidthKbps

            networkState = if (context.isConnected) {
                if (downSpeed!! > minDownSpeed && upSpeed!! > minUploadSpeed) {
                    ConnectionStates.Available
                } else {
                    ConnectionStates.Bad
                }
            } else {
                if (downSpeed == null || upSpeed == null) {
                    ConnectionStates.AirPlaneMode
                } else {
                    ConnectionStates.Unavailable
                }
            }
            postValue(networkState)
        }
    }

    override fun onActive() {
        super.onActive()
        context.registerReceiver(
            networkReceiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }

    override fun onInactive() {
        super.onInactive()
        try {
            context.unregisterReceiver(networkReceiver)
        } catch (e: Exception) {
            Log.e("NetworkOnInActiveError:", e.message.toString())
        }
    }
}
val Context.isConnected: Boolean
    get() = (getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)?.activeNetworkInfo?.isConnected == true