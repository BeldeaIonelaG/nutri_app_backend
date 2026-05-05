package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.NutrientIntakeEntity
import com.example.nutriapp.backend.entity.NutrientIntakeKey
import org.springframework.data.jpa.repository.JpaRepository

interface NutrientIntakeRepository :
    JpaRepository<NutrientIntakeEntity, NutrientIntakeKey>