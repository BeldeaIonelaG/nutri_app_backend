package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.PantryAccessEntity
import com.example.nutriapp.backend.entity.PantryAccessKey
import org.springframework.data.jpa.repository.JpaRepository



interface PantryAccessRepository :
    JpaRepository<PantryAccessEntity, PantryAccessKey> {

    fun findByIdPantryId(
        pantryId: Int
    ): List<PantryAccessEntity>

    fun findByIdUserId(
        userId: Int
    ): List<PantryAccessEntity>
}