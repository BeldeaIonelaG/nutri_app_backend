package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.service.NutrientIntakeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/nutrient-intakes")
class NutrientIntakeController(private val service: NutrientIntakeService) {

    @GetMapping("/user/{userId}/totals")
    fun getTotals(@PathVariable userId: Int) =
        service.getDailyTotals(userId)
}