package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.CompositionAlimentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CompositionAlimentRepository :
    JpaRepository<CompositionAlimentEntity, Int> {

    fun findByIdAliment(idAliment: Int): List<CompositionAlimentEntity>
    fun deleteByIdAliment(idAliment: Int)

}

