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

    @GetMapping
    fun getByUser(
        principal: java.security.Principal
    ): List<AllergyDTO> {

        val userId =
            principal.name.toInt()

        return service.getByUser(userId)
    }

    @PostMapping
    fun add(
        principal: java.security.Principal,
        @RequestBody dto: AllergyDTO
    ): AllergyDTO {

        val userId =
            principal.name.toInt()

        return service.add(
            dto.copy(userId = userId)
        )
    }

    @DeleteMapping("/{alimentId}")
    fun remove(
        principal: java.security.Principal,
        @PathVariable alimentId:Int
    ){

        val userId =
            principal.name.toInt()

        service.remove(
            userId,
            alimentId
        )
    }
}