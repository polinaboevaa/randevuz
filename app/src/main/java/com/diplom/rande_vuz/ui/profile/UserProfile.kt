package com.diplom.rande_vuz.ui.profile

@com.google.firebase.firestore.IgnoreExtraProperties
data class UserProfile(
    val name: String = "",
    val age: Int = 0,
    val university: String = "",
    val course: String = "",
    val skills: String = "",
    val about: String = "",
    val photoUrl: String? = null
)

