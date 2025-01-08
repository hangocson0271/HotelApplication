package com.example.hotelapplication.extentions

fun singleClick(onClick: () -> Unit): () -> Unit {
    var latest: Long = 0
    return {
        val now = System.currentTimeMillis()
        if (now - latest >= 300) {
            onClick()
            latest = now
        }
    }
}