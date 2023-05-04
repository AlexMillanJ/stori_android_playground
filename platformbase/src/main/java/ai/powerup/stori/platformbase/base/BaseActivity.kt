package ai.powerup.stori.platformbase.base

import ai.powerup.stori.platformbase.common.utils.NetworkObserver
import ai.powerup.stori.platformbase.storage.CacheUtmValues
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

/**
 * Constructor example implementation
 * MyBinding::inflate
 */
abstract class BaseActivity<VB: ViewBinding>(private val bindingFactory: (LayoutInflater) -> VB): AppCompatActivity() {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    //@Inject
    lateinit var networkObserver: NetworkObserver

    @Inject
    lateinit var cacheUtmValues: CacheUtmValues

    /**
     * LIFECYCLE FUNCTIONS
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkObserver = NetworkObserver(this)
        _binding = bindingFactory(layoutInflater)
        setContentView(requireNotNull(_binding?.root))
        initActivityView(savedInstanceState)
        BaseSessionTimer.startTimer(activity = this)
    }

    protected abstract fun initActivityView(savedInstanceState: Bundle? = null)

    override fun onResume() {
        super.onResume()
        observeNetworkConnectivity()
    }

    override fun onPause() {
        super.onPause()
        safelyDisposeNetworkObserver()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    /**
     * BASE FUNCTIONS
     */

    private fun observeNetworkConnectivity() {
        networkObserver.observeNetworkConnectivity()
    }

    private fun safelyDisposeNetworkObserver() {
        networkObserver.safelyDisposeNetworkObserver()
    }
}