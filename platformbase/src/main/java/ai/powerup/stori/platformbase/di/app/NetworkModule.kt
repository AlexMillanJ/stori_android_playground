package ai.powerup.stori.platformbase.di.app

import ai.powerup.stori.platformbase.base.BaseRetrofitObject
import ai.powerup.stori.platformbase.di.qualifiers.GsonBase
import ai.powerup.stori.platformbase.di.qualifiers.StoriBase
import ai.powerup.stori.platformbase.di.qualifiers.TurboBase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @AppScope
    @GsonBase
    fun provideGson(): Gson = Gson()

    @Provides
    @AppScope
    fun providesGsonBuilder(): Gson =
        GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

    @Provides
    @AppScope
    @StoriBase
    fun provideRetrofitStoriBase(retrofitObject: BaseRetrofitObject): Retrofit.Builder =
        retrofitObject(
            baseUrl = "",
            requestToken = BaseRetrofitObject.RequestToken.STORI_BASE
        )

    @Provides
    @AppScope
    @TurboBase
    fun provideRetrofitTurboBase(retrofitObject: BaseRetrofitObject): Retrofit.Builder =
        retrofitObject(
            baseUrl = "",
            requestToken = BaseRetrofitObject.RequestToken.TURBO_BASE
        )

}