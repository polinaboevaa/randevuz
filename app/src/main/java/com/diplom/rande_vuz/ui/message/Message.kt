package com.diplom.rande_vuz.ui.message

data class Message(
    val id: String = "",
    val content: String = "",
    val timestamp: Long = 0L,
    val senderId: String = "",
    val read: Boolean = false
)
