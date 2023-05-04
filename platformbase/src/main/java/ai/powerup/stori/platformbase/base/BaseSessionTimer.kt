package ai.powerup.stori.platformbase.base

import android.os.CountDownTimer
import androidx.activity.ComponentActivity

object BaseSessionTimer {

    var countDownTimer: CountDownTimer? = null

    fun startTimer(activity: ComponentActivity) {
        if (countDownTimer == null) {
            countDownTimer = object : CountDownTimer(60 * 60 * 1000, 1000) {
                override fun onTick(millisUntilFinished: Long) {}

                override fun onFinish() {}
            }
            countDownTimer?.start()
        }
    }
}