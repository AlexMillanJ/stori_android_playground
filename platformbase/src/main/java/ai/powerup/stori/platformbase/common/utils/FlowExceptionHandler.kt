package ai.powerup.stori.platformbase.common.utils

import ai.powerup.stori.platformbase.base.BaseErrorHandler
import kotlinx.coroutines.CoroutineExceptionHandler

val flowExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    val error = BaseErrorHandler.handleExceptionMessage(exception = throwable as Exception)
}