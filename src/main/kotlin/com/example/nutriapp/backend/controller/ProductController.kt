package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.ProductDTO
import com.example.nutriapp.backend.service.ProductService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val service: ProductService
) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.getById(id)

    @PostMapping
    fun create(@RequestBody dto: ProductDTO) =
        service.create(dto)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: ProductDTO) =
        service.update(id, dto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) =
        service.delete(id)
}