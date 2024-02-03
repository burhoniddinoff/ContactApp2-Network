package com.example.contactappwithinternet2.utils

fun <T> T.myApply(block: T.() -> Unit) {
    block(this)
}

