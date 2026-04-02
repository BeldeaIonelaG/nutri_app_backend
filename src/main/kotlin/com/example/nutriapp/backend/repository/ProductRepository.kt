package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Int>