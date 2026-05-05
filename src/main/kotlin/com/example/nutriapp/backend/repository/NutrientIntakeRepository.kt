package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.NutrientIntakeEntity
import com.example.nutriapp.backend.entity.NutrientIntakeId
import org.springframework.data.jpa.repository.JpaRepository

interface NutrientIntakeRepository :
    JpaRepository<NutrientIntakeEntity, NutrientIntakeId>