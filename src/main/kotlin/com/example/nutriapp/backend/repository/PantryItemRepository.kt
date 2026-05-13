package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.PantryItemEntity
import com.example.nutriapp.backend.entity.PantryItemKey
import org.springframework.data.jpa.repository.JpaRepository

interface PantryItemRepository :
    JpaRepository<PantryItemEntity, PantryItemKey> {

    fun findByIdPantryId(
        pantryId: Int
    ): List<PantryItemEntity>
}
