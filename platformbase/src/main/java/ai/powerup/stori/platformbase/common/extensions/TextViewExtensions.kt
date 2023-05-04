package ai.powerup.stori.platformbase.common.extensions

import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView

fun TextView.underlineText(text: String) {
    val content = SpannableString(text)
    content.setSpan(UnderlineSpan(), 0, content.length, 0)
    this.text = content
}

fun TextView.clear() {
    this.text = ""
}