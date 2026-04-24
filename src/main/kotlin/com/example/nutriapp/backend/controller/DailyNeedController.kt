package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.DailyNeedDTO
import com.example.nutriapp.backend.service.DailyNeedService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/daily-needs")
class DailyNeedController(
    private val service: DailyNeedService
) {

    // ✅ ONLY current user's data
    @GetMapping("/{userId}")
    fun getByUser(@PathVariable userId: Int) =
        service.getByUser(userId)

    // ✅ Replace all (sync endpoint)
    @PostMapping("/{userId}")
    fun replaceAll(
        @PathVariable userId: Int,
        @RequestBody needs: List<DailyNeedDTO>
    ) =
        service.replaceAll(userId, needs)
}