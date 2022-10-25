package com.poddlybonk.organize

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform