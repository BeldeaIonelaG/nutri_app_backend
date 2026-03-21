package com.example.nutriapp.backend

import java.io.Serializable

data class AllergyId(
    val userId: Int = 0,
    val alimentId: Int = 0
) : Serializable