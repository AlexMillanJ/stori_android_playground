package ai.powerup.stori.platformbase.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Constructor example implementation
 * MyBinding::inflate
 */
abstract class BaseFragment<VB: ViewBinding>(
    private val inflateMethod: (LayoutInflater, ViewGroup?, Boolean) -> VB
): Fragment() {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = inflateMethod.invoke(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragmentViewComponent(view, savedInstanceState)
    }

    protected abstract fun initFragmentViewComponent(view: View, savedInstanceState: Bundle?)

    protected fun backAction(action: () -> Unit){
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                action.invoke()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}