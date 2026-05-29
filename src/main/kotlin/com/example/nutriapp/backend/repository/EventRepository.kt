package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.EventEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface EventRepository : JpaRepository<EventEntity, Int>
{
    @Query("""select distinct e
            from EventEntity e
            left join e.invitations i
            where e.hostId = :userId
            or i.id.personId = :userId""")
    fun findVisibleEvents(
        userId:Int
    ): List<EventEntity>
}