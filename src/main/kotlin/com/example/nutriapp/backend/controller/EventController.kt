package com.example.nutriapp.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.nutriapp.backend.service.EventService

@RestController
@RequestMapping("/events")
class EventController(private val service: EventService) {

    @GetMapping
    fun getAll() = service.getAll()
}