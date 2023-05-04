package ai.powerup.stori.platformbase.common.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Snackbar.action(actionTitle: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(actionTitle, listener)
    color?.let { setActionTextColor(color) }
}