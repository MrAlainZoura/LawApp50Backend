package emy.backend.lawapp50.utils

fun Int.generateOtp(): String {
    return (0 until this)
        .map { (0..9).random() }
        .joinToString("")
}
