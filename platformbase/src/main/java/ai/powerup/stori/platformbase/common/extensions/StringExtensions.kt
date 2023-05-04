package ai.powerup.stori.platformbase.common.extensions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.fragment.app.FragmentActivity

fun String.copyToClipboard(activity: FragmentActivity) {
    val clipboardManager = activity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
    clipboardManager?.let {
        it.setPrimaryClip(ClipData.newPlainText(null, this))
        if (it.hasPrimaryClip()) {
            it.primaryClip?.getItemAt(0)?.text
        }
    }
}