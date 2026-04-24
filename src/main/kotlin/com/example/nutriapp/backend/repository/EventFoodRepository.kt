package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.EventFoodEntity
import com.example.nutriapp.backend.entity.EventFoodId
import org.springframework.data.jpa.repository.JpaRepository

interface EventFoodRepository :
    JpaRepository<EventFoodEntity, EventFoodId>
