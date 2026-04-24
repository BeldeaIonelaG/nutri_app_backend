package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.PantryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PantryRepository : JpaRepository<PantryEntity, Int> {
    fun findByOwnerId(ownerId: Int): List<PantryEntity>
}