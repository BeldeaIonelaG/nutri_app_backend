package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.NutrientIntakeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NutrientIntakeRepository : JpaRepository<NutrientIntakeEntity, Int>