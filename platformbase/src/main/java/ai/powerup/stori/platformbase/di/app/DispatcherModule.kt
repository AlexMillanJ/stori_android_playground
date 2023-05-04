package ai.powerup.stori.platformbase.di.app

import ai.powerup.stori.platformbase.di.qualifiers.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class DispatcherModule {

    @DefaultDispatcher
    @Provides
    fun provideDefaultDispatcher() : CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun provideIoDispatcher() : CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun provideMainDispatcher() : CoroutineDispatcher = Dispatchers.Main

    @ImmediateDispatcher
    @Provides
    fun provideImmediateDispatcher() : CoroutineDispatcher = Dispatchers.Main.immediate

    @UnconfinedDispatcher
    @Provides
    fun provideUnconfinedDispatcher() : CoroutineDispatcher = Dispatchers.Unconfined
}