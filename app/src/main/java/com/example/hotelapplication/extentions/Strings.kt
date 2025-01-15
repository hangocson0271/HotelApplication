package com.example.hotelapplication.extentions

import java.util.regex.Pattern

internal fun isValidPassword(password: String): Boolean {
    if (password.length < 8) return false
    if (password.filter { it.isDigit() }.firstOrNull() == null) return false
    if (password.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null) return false
    if (password.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) return false
    if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

    return true
}

internal fun isPhoneNumber(phone: String) : Boolean {
    val regex = Regex("""(03|05|07|08|09|01[2689])[0-9]{8}\b""")
    return regex.matches(phone)
}

internal fun isEmail(email: String) : Boolean {
    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
}