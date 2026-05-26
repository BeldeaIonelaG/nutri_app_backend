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

    @GetMapping
    fun getByUser(
        principal: java.security.Principal
    ): List<DailyNeedDTO> {
        return service.getByUser()
    }

    @PostMapping
    fun replaceAll(
        principal: java.security.Principal,
        @RequestBody needs: List<DailyNeedDTO>
    ) {

        val userId =
            principal.name.toInt()

        service.replaceAll(
            userId,
            needs
        )
    }
}