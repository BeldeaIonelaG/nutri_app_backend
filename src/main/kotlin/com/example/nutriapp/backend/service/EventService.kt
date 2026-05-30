package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.EventDTO
import com.example.nutriapp.backend.dto.EventInvitationDTO
import com.example.nutriapp.backend.entity.EventFoodEntity
import com.example.nutriapp.backend.entity.EventFoodId
import com.example.nutriapp.backend.entity.EventInvitationEntity
import com.example.nutriapp.backend.entity.EventInvitationId
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.EventFoodRepository
import com.example.nutriapp.backend.repository.EventInvitationRepository
import com.example.nutriapp.backend.repository.EventRepository
import jakarta.transaction.Transactional
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.time.LocalDateTime

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

    @Transactional
    fun updateInvitation(
        dto: EventInvitationDTO
    ){
        val userId = (SecurityContextHolder.getContext().authentication?.principal ?: 0) as Int
        val invitation =
            invitationRepo.findById(
                EventInvitationId(dto.personId, //we only get 2 things from the Android app an int and a status; I've chosen to reuse the personId as eventId
                    userId,
                )
            ).orElseThrow()

        invitation.status = dto.status

        invitationRepo.save(invitation)
    }

    @Transactional
    fun update(
        eventId:Int,
        dto:EventDTO,
        userId:Int
    ): EventDTO {
        val event =
            eventRepo.findById(eventId)
                .orElseThrow()

        if(event.hostId != userId){

            throw RuntimeException(
                "Only host can edit event"
            )
        }

        event.beginDateTime =
            LocalDateTime.parse(
                dto.beginDateTime
            )

        event.endDateTime =
            LocalDateTime.parse(
                dto.endDateTime
            )

        event.name =
            dto.name

        event.description =
            dto.description

        eventRepo.save(event)

        invitationRepo
            .deleteByIdEventId(eventId)

        foodRepo
            .deleteByIdIdEvent(eventId)

        dto.invitations.forEach {

            invitationRepo.save(

                EventInvitationEntity(

                    id =
                        EventInvitationId(
                            eventId,
                            it.personId
                        ),

                    status =
                        it.status,

                    event =
                        event
                )
            )
        }

        dto.foods.forEach {

            foodRepo.save(

                EventFoodEntity(

                    id =
                        EventFoodId(
                            eventId,
                            it.idFood,
                            it.type
                        ),

                    event =
                        event
                )
            )
        }

        return eventRepo
            .findById(eventId)
            .get()
            .toDTO()
    }
}