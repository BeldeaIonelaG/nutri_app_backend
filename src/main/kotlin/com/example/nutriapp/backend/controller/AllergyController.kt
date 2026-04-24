package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.AllergyDTO
import com.example.nutriapp.backend.service.AllergyService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/allergies")
class AllergyController(
    private val service: AllergyService
) {

    @GetMapping("/{userId}")
    fun getByUser(@PathVariable userId: Int): List<AllergyDTO> =
        service.getByUser(userId)

    @PostMapping
    fun add(@RequestBody dto: AllergyDTO): AllergyDTO =
        service.add(dto)

    @DeleteMapping
    fun remove(@RequestBody dto: AllergyDTO) =
        service.remove(dto)
}