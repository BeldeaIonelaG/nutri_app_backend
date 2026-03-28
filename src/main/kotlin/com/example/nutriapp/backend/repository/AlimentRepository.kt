package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.AlimentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AlimentRepository : JpaRepository<AlimentEntity, Int>

