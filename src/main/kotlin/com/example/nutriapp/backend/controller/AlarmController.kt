package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.AlarmDTO
import com.example.nutriapp.backend.service.AlarmService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/alarms")
class AlarmController(
    private val service: AlarmService
) {

    @PostMapping
    fun create(@RequestBody dto: AlarmDTO): AlarmDTO =
        service.create(dto)

    @GetMapping("/user/{userId}")
    fun getByUser(@PathVariable userId: Int): List<AlarmDTO> =
        service.getByUser(userId)

    @GetMapping("/event/{eventId}")
    fun getByEvent(@PathVariable eventId: Int): List<AlarmDTO> =
        service.getByEvent(eventId)
}