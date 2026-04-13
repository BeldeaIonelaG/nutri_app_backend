package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.CookbookDTO
import com.example.nutriapp.backend.entity.CookbookEntity
import com.example.nutriapp.backend.service.CookbookService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cookbooks")
class CookbookController(
    private val service: CookbookService
) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.getById(id)

    @PostMapping
    fun create(@RequestBody dto: CookbookDTO) =
        service.create(dto)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Int,
        @RequestBody dto: CookbookDTO
    ) = service.update(id, dto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) =
        service.delete(id)

    @GetMapping
    fun getMyCookbooks(): List<CookbookEntity> {

        val auth = SecurityContextHolder.getContext().authentication

        val userId = (auth?.principal ?: 0) as Int

        println("👤 CURRENT USER ID: $userId")

        return service.getByUser(userId)
    }
}