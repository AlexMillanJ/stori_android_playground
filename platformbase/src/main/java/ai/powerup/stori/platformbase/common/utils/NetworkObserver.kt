package ai.powerup.stori.platformbase.common.utils

import android.app.Activity
import android.net.NetworkInfo
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NetworkObserver(private val context: Activity) {

    private var networkDisposable: Disposable = CompositeDisposable()

    fun isNetworkObserverEnabled(): Boolean = true

    fun observeNetworkConnectivity() {
        if (isNetworkObserverEnabled()) {
            networkDisposable = ReactiveNetwork.observeNetworkConnectivity(context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { connectivity: Connectivity ->
                    val state: NetworkInfo.State = connectivity.state()
                    if (state == NetworkInfo.State.DISCONNECTED) {
                        showNetworkLostAlert()
                    }
                }
        }
    }

    fun showNetworkLostAlert() {}

    fun safelyDisposeNetworkObserver() {
        if (networkDisposable.isDisposed.not()) networkDisposable.dispose()
    }
}