package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.PantryDTO
import com.example.nutriapp.backend.service.PantryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pantries")
class PantryController(
    private val service: PantryService
) {

    @PostMapping
    fun create(@RequestBody dto: PantryDTO): PantryDTO =
        service.create(dto)

    @GetMapping
    fun getUserPantries(@RequestParam userId: Int): List<PantryDTO> =
        service.getByUser(userId)
}