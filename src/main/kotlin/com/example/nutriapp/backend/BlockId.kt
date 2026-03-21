package com.example.nutriapp.backend

import java.io.Serializable

data class BlockId(
    val blockerId: Int = 0,
    val blockedId: Int = 0
) : Serializable