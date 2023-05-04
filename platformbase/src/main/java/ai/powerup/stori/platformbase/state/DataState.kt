package ai.powerup.stori.platformbase.state

import ai.powerup.stori.platformbase.data.error.BaseError

sealed class DataState<out R> {
    object Loading: DataState<Nothing>()
    data class Success<out T: Any>(val data: T): DataState<T>()
    data class Error(val error: BaseError): DataState<Nothing>()
    object Idle: DataState<Nothing>()
}