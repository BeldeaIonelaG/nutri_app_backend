package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.EventDTO
import com.example.nutriapp.backend.entity.EventFoodEntity
import com.example.nutriapp.backend.entity.EventFoodId
import com.example.nutriapp.backend.entity.EventInvitationEntity
import com.example.nutriapp.backend.entity.EventInvitationId
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.EventFoodRepository
import com.example.nutriapp.backend.repository.EventInvitationRepository
import com.example.nutriapp.backend.repository.EventRepository
import org.springframework.stereotype.Service

@Service
class EventService(
    private val eventRepo: EventRepository,
    private val invitationRepo: EventInvitationRepository,
    private val foodRepo: EventFoodRepository
) {

    fun getAll(userId: Int): List<EventDTO> =
        eventRepo.findAll().map { it.toDTO() }

    fun create(dto: EventDTO, userId: Int): EventDTO {

        val event = dto.toEntity(userId)
        val saved = eventRepo.save(event)

        // invitations
        dto.invitations.forEach {
            val inv = EventInvitationEntity(
                id = EventInvitationId(saved.id, it.personId),
                status = it.status,
                event = saved
            )
            invitationRepo.save(inv)
        }

        // foods
        dto.foods.forEach { postId ->
            val food = EventFoodEntity(
                id = EventFoodId(saved.id, postId),
                event = saved
            )
            foodRepo.save(food)
        }

        return eventRepo.findById(saved.id).get().toDTO()
    }
}