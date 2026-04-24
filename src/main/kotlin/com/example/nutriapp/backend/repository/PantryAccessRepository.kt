package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.PantryAccessEntity
import org.springframework.data.jpa.repository.JpaRepository


interface PantryAccessRepository : JpaRepository<PantryAccessEntity, Int> {
    fun findByPantryId(pantryId: Int): List<PantryAccessEntity>
    fun findByUserId(userId: Int): List<PantryAccessEntity>
}