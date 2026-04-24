package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.PantryItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PantryItemRepository : JpaRepository<PantryItemEntity, Int> {
    fun findByPantryId(pantryId: Int): List<PantryItemEntity>
}