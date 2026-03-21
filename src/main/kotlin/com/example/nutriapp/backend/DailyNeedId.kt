package com.example.nutriapp.backend

import java.io.Serializable

data class DailyNeedId(
    val userId: Int = 0,
    val nutrientId: Int = 0
) : Serializable