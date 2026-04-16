package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.RecipeDTO
import com.example.nutriapp.backend.service.RecipeService
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
@RequestMapping("/recipes")
class RecipeController(
    private val service: RecipeService
) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.getById(id)

    @PostMapping
    fun create(@RequestBody dto: RecipeDTO): RecipeDTO {
        val userId = (SecurityContextHolder
            .getContext()
            .authentication
            ?.principal ?: 0) as Int
        return service.create(dto,)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Int,
        @RequestBody dto: RecipeDTO
    ) = service.update(id, dto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) =
        service.delete(id)
}
