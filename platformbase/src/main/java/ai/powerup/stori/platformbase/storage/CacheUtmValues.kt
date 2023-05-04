package ai.powerup.stori.platformbase.storage

import android.content.Context
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CacheUtmValues @Inject constructor(
    @ApplicationContext private val context: Context
    ) {

    operator fun invoke(uri: Uri) {
        val url: String = uri.toString()
    }
}