package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.repository.AllergyRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/allergies")
class AllergyController(private val repo: AllergyRepository) {

    @GetMapping
    fun getAll() = repo.findAll()
}
