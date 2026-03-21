package com.example.nutriapp.backend

import java.io.Serializable

data class FollowId(
    val followerId: Int = 0,
    val followedId: Int = 0
) : Serializable