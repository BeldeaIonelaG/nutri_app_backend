package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.entity.IntakeEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.nutriapp.backend.service.IntakeService

@RestController
@RequestMapping("/intakes")
class IntakeController(private val service: IntakeService) {

    @GetMapping
    fun getAll() = service.getAll()

    @PostMapping
    fun create(@RequestBody intake: IntakeEntity) = service.create(intake)
}