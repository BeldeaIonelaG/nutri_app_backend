package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.EventInvitationEntity
import com.example.nutriapp.backend.entity.EventInvitationId
import org.springframework.data.jpa.repository.JpaRepository


interface EventInvitationRepository :
    JpaRepository<EventInvitationEntity, EventInvitationId>


