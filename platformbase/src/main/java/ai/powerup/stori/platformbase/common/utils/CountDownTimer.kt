package ai.powerup.stori.platformbase.common.utils

import ai.powerup.stori.platformbase.common.utils.Constants.ZERO_DURATION_MS
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class CountDownTimer(
    private val millisInFuture: Long,
    private val countDownInterval: Long,
    private val scope: CoroutineScope,
    dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    private var countDownJob: Job? = null

    private val countDownFlow: Flow<Long> = flow {
        val startTime = System.currentTimeMillis()
        var elapsedTime = ZERO_DURATION_MS

        while (elapsedTime <= millisInFuture && scope.isActive) {
            scope.coroutineContext.ensureActive()
            delay(countDownInterval)
            elapsedTime = System.currentTimeMillis() - startTime
            val remainingTime = millisInFuture - elapsedTime
            emit(remainingTime)
        }
    }.flowOn(dispatcher).onCompletion { cause ->
        if (cause != null && cause !is CancellationException) {
            emit(0)
        }
    }.catch {
        emit(0)
    }

    @Synchronized
    fun start(
        onTick: (timeLeft: Long) -> Unit,
        onFinish: () -> Unit
    ) {
        countDownJob?.cancel()
        countDownJob = scope.launch {
            countDownFlow.collect { remainingTime ->
                onTick(remainingTime)
                if (remainingTime <= ZERO_DURATION_MS) {
                    onFinish()
                }
            }
        }
    }

    fun cancel() = countDownJob?.cancel()
}