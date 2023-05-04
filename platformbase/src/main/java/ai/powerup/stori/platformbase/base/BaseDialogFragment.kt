package ai.powerup.stori.platformbase.base

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<VB: ViewBinding>(
    private val inflateMethod: (LayoutInflater, ViewGroup?, Boolean) -> VB
): DialogFragment() {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateMethod.invoke(inflater, parent, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponentDialogFragmentView()
    }

    protected abstract fun initComponentDialogFragmentView(savedInstanceState: Bundle? = null)

    protected fun setFullScreen(){
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    protected fun dismissBackAction(action: () -> Unit){
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                dialog?.dismiss()
                action.invoke()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun dismiss() = dismissAllowingStateLoss()

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        _binding = null
    }
}