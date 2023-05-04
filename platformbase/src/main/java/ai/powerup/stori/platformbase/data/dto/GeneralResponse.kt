package ai.powerup.stori.platformbase.data.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GeneralResponse(

        @SerializedName("code")
        var code: Int = 0,

        @SerializedName("message")
        var message: String = "",

        @SerializedName("status")
        var status: String = "",

        @SerializedName("error")
        var error: String = ""

): Parcelable