package ai.powerup.stori.platformbase.common.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit

inline fun <reified T: Activity> Activity.beginActivity(bundle: Bundle? = null) {
    startActivity(Intent(this, T::class.java).apply {
        bundle?.let { putExtras(it) }
    })
}

fun AppCompatActivity.replaceFragment(
    fragment: Fragment,
    tag: String? = null,
    @IdRes container: Int,
    transition: Int = FragmentTransaction.TRANSIT_NONE,
    backStack: String? = null,
    bundle: Bundle? = null
) {
    bundle?.let {
        fragment.arguments = bundle
    }
    supportFragmentManager
        .commit(allowStateLoss = true) {
            setTransition(transition)
            replace(container, fragment, tag)
            addToBackStack(backStack)
        }
}

fun Activity.statusBarColor(@ColorRes color: Int) {
    this.window.statusBarColor = ContextCompat.getColor(this, color)
    this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}

fun Activity.showKeyboard() {
    currentFocus?.let {
        (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
            .showSoftInput(it, InputMethodManager.RESULT_UNCHANGED_SHOWN)
    }
}

fun Activity.hideKeyboard() {
    currentFocus?.let {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(it.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
    }
}