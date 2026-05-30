package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.EventDTO
import com.example.nutriapp.backend.dto.EventInvitationDTO
import com.example.nutriapp.backend.service.EventService
import org.springframework.security.core.Authentication

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/events")
class EventController(
    private val service: EventService
) {

    @GetMapping
    fun getAll(authentication: Authentication): List<EventDTO> {
        val userId = authentication.principal.toString().toInt()

        println("📥 GET /events by user=$userId")

        return service.getAll(userId)
    }

    @PostMapping
    fun create(
        @RequestBody dto: EventDTO,
        authentication: Authentication
    ): EventDTO {

        val userId = authentication.principal.toString().toInt()

        println("📤 POST /events by user=$userId")
        println("➡️ DTO: $dto")

        return service.create(dto, userId)
    }

    @PutMapping("/invitation")
    fun updateInvitation(
        @RequestBody dto: EventInvitationDTO
    ){
        service.updateInvitation(dto)
    }

    @PutMapping("/{id}")
    fun update(

        @PathVariable id:Int,

        @RequestBody dto:EventDTO,

        authentication:Authentication

    ):EventDTO{

        val userId =
            authentication.principal
                .toString()
                .toInt()

        return service.update(
            id,
            dto,
            userId
        )
    }
}