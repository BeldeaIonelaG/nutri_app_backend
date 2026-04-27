package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.FoodPreferenceDTO
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.FoodPreferenceRepository
import com.example.nutriapp.backend.service.FoodPreferenceService
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/preferences")
class FoodPreferenceController(
    private val service: FoodPreferenceService
) {

    @GetMapping("/{userId}")
    fun getByUser(@PathVariable userId: Int) =
        service.getByUser(userId)

    @PostMapping
    fun add(@RequestBody dto: FoodPreferenceDTO) =
        service.add(dto)

    @DeleteMapping
    fun remove(@RequestBody dto: FoodPreferenceDTO) =
        service.remove(dto)
}