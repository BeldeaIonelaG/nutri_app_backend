package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.IngredientEntity
import com.example.nutriapp.backend.entity.IngredientId
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientRepository :
    JpaRepository<IngredientEntity, IngredientId>
