package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.IntakeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface IntakeRepository : JpaRepository<IntakeEntity, Int>

