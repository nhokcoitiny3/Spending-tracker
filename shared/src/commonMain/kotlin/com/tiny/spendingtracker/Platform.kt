package com.tiny.spendingtracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform