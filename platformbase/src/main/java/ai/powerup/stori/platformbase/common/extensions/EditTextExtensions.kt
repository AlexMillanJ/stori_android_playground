package ai.powerup.stori.platformbase.common.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.textListener(
    beforeTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null,
    onTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null,
    afterTextChanged: (Editable?) -> Unit
) {
    this.addTextChangedListener(
        object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                beforeTextChanged?.invoke(p0, p1, p2, p3)
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                onTextChanged?.invoke(p0, p1, p2, p3)
            }
            override fun afterTextChanged(p0: Editable?) {
                afterTextChanged.invoke(p0)
            }
        }
    )
}