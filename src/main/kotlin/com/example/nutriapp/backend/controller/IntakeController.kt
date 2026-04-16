package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.IntakeDTO
import com.example.nutriapp.backend.service.IntakeService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/intakes")
class IntakeController(
    private val service: IntakeService
) {

    @GetMapping
    fun getAll(): List<IntakeDTO> {
        val userId = (SecurityContextHolder
            .getContext()
            .authentication?.principal ?: 0
            ) as Int

        return service.getAll(userId)
    }

    @PostMapping
    fun create(@RequestBody dto: IntakeDTO): IntakeDTO {

        val userId = (SecurityContextHolder
            .getContext()
            .authentication?.principal ?: 0) as Int

        return service.create(dto, userId)
    }
}