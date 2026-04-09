package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.CookbookEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CookbookRepository : JpaRepository<CookbookEntity, Int>