package ai.powerup.stori.platformbase.common.extensions

import androidx.fragment.app.Fragment

inline fun <reified T: Fragment> canonicalTag(): String = T::class.java.canonicalName!!