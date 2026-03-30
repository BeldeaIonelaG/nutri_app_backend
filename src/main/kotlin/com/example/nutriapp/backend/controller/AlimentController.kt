package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.AlimentDTO
import com.example.nutriapp.backend.service.AlimentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/aliments")
class AlimentController(
    private val service: AlimentService
) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = service.getById(id)

    @PostMapping
    fun create(@RequestBody dto: AlimentDTO): AlimentDTO {
        return service.create(dto)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Int,
        @RequestBody dto: AlimentDTO
    ) = service.update(id, dto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) =
        service.delete(id)
}
