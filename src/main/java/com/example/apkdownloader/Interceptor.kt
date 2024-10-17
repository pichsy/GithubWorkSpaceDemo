package com.example.apkdownloader

interface Interceptor {
    fun intercept(chain: Chain)

    interface Chain {
        fun proceed()
    }
}
