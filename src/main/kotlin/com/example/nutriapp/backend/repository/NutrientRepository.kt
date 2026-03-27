package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.NutrientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NutrientRepository : JpaRepository<NutrientEntity, Int>
