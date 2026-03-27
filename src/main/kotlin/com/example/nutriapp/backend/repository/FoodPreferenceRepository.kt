package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.FoodPreferenceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FoodPreferenceRepository : JpaRepository<FoodPreferenceEntity, Int>

