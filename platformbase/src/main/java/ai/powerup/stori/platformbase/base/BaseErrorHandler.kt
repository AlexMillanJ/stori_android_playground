package ai.powerup.stori.platformbase.base

import ai.powerup.stori.platformbase.data.error.ErrorType
import retrofit2.HttpException
import java.io.IOException

object BaseErrorHandler {
    fun handleExceptionMessage(exception: Exception): Int {
        return when (exception) {
            is IOException -> ErrorType.getErrorMessage(errorCode = -2000)
            is HttpException -> ErrorType.getErrorMessage(errorCode = exception.code())
            else -> ErrorType.getErrorMessage(errorCode = -1000)
        }
    }
}