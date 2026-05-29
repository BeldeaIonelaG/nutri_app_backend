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
        eventRepo.findVisibleEvents(userId).map {it.toDTO()}
        //eventRepo.findAll().map { it.toDTO() }

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
        dto.foods.forEach {
            foodRepo.save(
                EventFoodEntity(
                    id = EventFoodId(saved.id,it.idFood,it.type),
                    event = saved
                )
            )
        }

        return eventRepo.findById(saved.id).get().toDTO()
    }
}