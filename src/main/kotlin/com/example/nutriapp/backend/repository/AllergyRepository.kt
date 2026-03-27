package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.AllergyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AllergyRepository : JpaRepository<AllergyEntity, Int>
