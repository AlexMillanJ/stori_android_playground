package ai.powerup.stori.platformbase.base

import ai.powerup.stori.platformbase.common.utils.Constants
import ai.powerup.stori.platformbase.di.qualifiers.GsonBase
import androidx.multidex.BuildConfig
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BaseRetrofitObject @Inject constructor(@GsonBase private val gson: Gson) {

    operator fun invoke(baseUrl: String, requestToken: RequestToken): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okhttpClient(requestToken))

    private fun okhttpClient(requestToken: RequestToken): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor { chain: Interceptor.Chain -> provideInterceptor(chain, requestToken )}
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = interceptorLevel(HttpLoggingInterceptor.Level.HEADERS)
            })
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = interceptorLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = interceptorLevel(HttpLoggingInterceptor.Level.BASIC)
            })
            .build()
    }

    private fun interceptorLevel(level: HttpLoggingInterceptor.Level): HttpLoggingInterceptor.Level =
        if (BuildConfig.DEBUG)
            level
        else
            HttpLoggingInterceptor.Level.NONE


    private fun provideInterceptor(
        chain: Interceptor.Chain, requestToken: RequestToken) : Response {
        val bearerToken = getAccessToken(requestToken)

        val request: Request = if (bearerToken.isNotBlank()) {
            chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer $bearerToken")
                .addHeader("x-api-key", "")
                .build()
        } else {
            chain.request()
                .newBuilder()
                .build()
        }
        return chain.proceed(request)
    }

    private fun getAccessToken(requestToken: RequestToken): String = when(requestToken) {
        RequestToken.STORI_BASE -> ""
        RequestToken.TURBO_BASE -> ""
    }

    enum class RequestToken {
        STORI_BASE,
        TURBO_BASE
    }
}