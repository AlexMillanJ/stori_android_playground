package ai.powerup.stori.platformbase.base

import ai.powerup.stori.platformbase.common.utils.NetworkObserver
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat

abstract class BaseComponentActivity: ComponentActivity() {

    lateinit var networkObserver: NetworkObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkObserver = NetworkObserver(this)
        BaseSessionTimer.startTimer(activity = this)
        setContent { SetScreenContent(savedInstanceState) }
    }

    override fun onResume() {
        super.onResume()
        observeNetworkConnectivity()
    }

    override fun onPause() {
        super.onPause()
        safelyDisposeNetworkObserver()
    }

    private fun observeNetworkConnectivity() {
        networkObserver.observeNetworkConnectivity()
    }

    private fun safelyDisposeNetworkObserver() {
        networkObserver.safelyDisposeNetworkObserver()
    }

    protected fun setFullScreen() =
        WindowCompat.setDecorFitsSystemWindows(window, false)

    @Composable
    abstract fun SetScreenContent(savedInstanceState: Bundle?)

}