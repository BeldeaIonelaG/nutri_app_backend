package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.repository.EventInvitationRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/event-invitations")
class EventInvitationController(private val repo: EventInvitationRepository) {

    @GetMapping
    fun getAll() = repo.findAll()
}