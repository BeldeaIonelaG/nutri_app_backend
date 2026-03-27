package com.example.nutriapp.backend.service

import org.springframework.stereotype.Service
import com.example.nutriapp.backend.repository.ProductRepository

@Service
class ProductService(private val repo: ProductRepository) {
    fun getAll() = repo.findAll()
}
