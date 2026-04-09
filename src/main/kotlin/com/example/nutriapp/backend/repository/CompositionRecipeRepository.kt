package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.CompositionRecipeEntity
import com.example.nutriapp.backend.entity.CompositionRecipeId
import org.springframework.data.jpa.repository.JpaRepository

interface CompositionRecipeRepository :
    JpaRepository<CompositionRecipeEntity, CompositionRecipeId>
