package ai.powerup.stori.platformbase.base

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding

abstract class BaseViewComponent<LISTENER_TYPE>(
    private val binding: ViewBinding
) {
    protected val context: Context get() = binding.root.context

    protected val listeners = HashSet<LISTENER_TYPE>()

    protected fun registerListener(listener: LISTENER_TYPE) {
        listeners.add(element = listener)
    }

    protected fun unregisterListener(listener: LISTENER_TYPE) {
        listeners.remove(element = listener)
    }

    protected fun loadingStatus(
        fragManager: FragmentManager,
        tag: String = "",
        isLoading: Boolean){}
}