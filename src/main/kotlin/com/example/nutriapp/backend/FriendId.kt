package com.example.nutriapp.backend

import java.io.Serializable

data class FriendId(
    val userId1: Int = 0,
    val userId2: Int = 0
) : Serializable