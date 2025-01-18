package com.diplom.rande_vuz.ui.message


sealed class SendStatus {
        object Success : SendStatus()
        data class Error(val exception: Throwable) : SendStatus()

}