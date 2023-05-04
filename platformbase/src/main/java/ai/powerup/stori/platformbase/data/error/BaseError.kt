package ai.powerup.stori.platformbase.data.error

import androidx.annotation.StringRes
import java.lang.Exception

data class BaseError(
    @StringRes var message: Int = ErrorType.UNKNOWN.message,
    var code: Int = ErrorType.UNKNOWN.codeValue,
    var exception: Exception? = null
)
