package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.SocialPostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SocialPostRepository : JpaRepository<SocialPostEntity, Int> {
    fun findByUserId(userId: Int): List<SocialPostEntity>
}

