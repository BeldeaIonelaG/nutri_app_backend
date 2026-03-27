package com.example.nutriapp.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.nutriapp.backend.service.AlimentService
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/aliments")
class AlimentController(private val service: AlimentService) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}/nutrients")
    fun getWithNutrients(@PathVariable id: Int) =
        service.getAlimentWithNutrients(id)

}
