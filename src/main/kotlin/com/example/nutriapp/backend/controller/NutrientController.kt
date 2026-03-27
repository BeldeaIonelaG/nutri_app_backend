package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.NutrientDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.nutriapp.backend.service.NutrientService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/nutrients")
class NutrientController(
    private val service: NutrientService
) {

    @GetMapping
    fun getAll(): List<NutrientDTO> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): NutrientDTO? =
        service.getById(id)

    @PostMapping
    fun create(@RequestBody dto: NutrientDTO): NutrientDTO =
        service.create(dto)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Int,
        @RequestBody dto: NutrientDTO
    ): NutrientDTO =
        service.update(id, dto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) =
        service.delete(id)
}
