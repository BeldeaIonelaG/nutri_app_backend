package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.NutrientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NutrientJpaRepository : JpaRepository<NutrientEntity, Int>

