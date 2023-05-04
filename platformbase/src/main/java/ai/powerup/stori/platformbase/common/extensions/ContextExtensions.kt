package ai.powerup.stori.platformbase.common.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

inline fun <reified T: Activity> Context.beginActivity(bundle: Bundle? = null) {
    startActivity(Intent(this, T::class.java).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        bundle?.let { putExtras(it) }
    })
}

@ColorInt
fun Context.obtainColor(@ColorRes id: Int) : Int =
    ContextCompat.getColor(this, id)

fun Context.openSettings() {
    val uri = Uri.fromParts("package", this.packageName, null)
    val intent = Intent().apply {
        action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        data = uri
    }
    this.startActivity(intent)
}