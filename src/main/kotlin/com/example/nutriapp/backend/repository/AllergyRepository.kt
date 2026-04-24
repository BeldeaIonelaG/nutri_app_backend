package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.AllergyEntity
import com.example.nutriapp.backend.entity.AllergyId
import org.springframework.data.jpa.repository.JpaRepository

interface AllergyRepository :
    JpaRepository<AllergyEntity, AllergyId> {

    fun findByUserId(userId: Int): List<AllergyEntity>

    fun deleteByUserIdAndAlimentId(userId: Int, alimentId: Int)
}