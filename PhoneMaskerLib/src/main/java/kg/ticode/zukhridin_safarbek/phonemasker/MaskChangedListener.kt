package kg.ticode.zukhridin_safarbek.phonemasker

import android.text.Editable
import android.text.TextWatcher


class MaskChangedListener(mask: Mask) : TextWatcher {

    private val phoneMasker: PhoneMasker = PhoneMasker(mask)

    private var selfChange: Boolean = false
    private var result: MaskResult? = null

    val masked: String
        get() = result?.masked.orEmpty()

    val unMasked: String
        get() = result?.unMasked.orEmpty()

    val isDone: Boolean
        get() = result?.isDone ?: false

    override fun afterTextChanged(s: Editable?) {
        if (selfChange || s.isNullOrEmpty()) return

        selfChange = true
        result?.apply(s)
        selfChange = false
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (selfChange || s.isNullOrEmpty()) return

        val action = if (before > 0 && count == 0) Action.DELETE else Action.INSERT
        result = phoneMasker.apply(s, action)
    }
}