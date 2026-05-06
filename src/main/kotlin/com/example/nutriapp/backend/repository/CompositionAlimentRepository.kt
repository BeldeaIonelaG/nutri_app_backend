package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.CompositionAlimentEntity
import com.example.nutriapp.backend.entity.CompositionAlimentKey
import org.springframework.data.jpa.repository.JpaRepository


interface CompositionAlimentRepository : JpaRepository<CompositionAlimentEntity, CompositionAlimentKey>