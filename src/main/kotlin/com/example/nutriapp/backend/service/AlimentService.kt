package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.AlimentDTO
import com.example.nutriapp.backend.entity.AlimentEntity
import com.example.nutriapp.backend.entity.CompositionAlimentEntity
import com.example.nutriapp.backend.entity.CompositionAlimentKey
import com.example.nutriapp.backend.entity.PostContentEntity
import com.example.nutriapp.backend.entity.PostContentKey
import com.example.nutriapp.backend.entity.SocialPostEntity
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.repository.AlimentRepository
import com.example.nutriapp.backend.repository.NutrientRepository
import com.example.nutriapp.backend.repository.SocialPostRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AlimentService(
    private val alimentRepo: AlimentRepository,
    private val nutrientRepo: NutrientRepository,
    private val socialRepo: SocialPostRepository
) {
    fun getAll(): List<AlimentDTO> =
        alimentRepo.findAll().map { it.toDTO() }

    fun getById(id: Int): AlimentDTO =
        alimentRepo.findById(id)
            .orElseThrow()
            .toDTO()

    fun create(dto: AlimentDTO): AlimentDTO {
        val aliment = AlimentEntity(
            name = dto.name,
            description = dto.description,
            type = dto.type,
            updatedAt = System.currentTimeMillis(),
            compositions = mutableListOf(),
            measurementUnit = dto.measurementUnit, // ✅ important
        )
        val saved = alimentRepo.save(aliment)

        dto.nutrients.forEach {
            val comp = CompositionAlimentEntity(
                id = CompositionAlimentKey(saved.id,it.idNutrient),
                amountPer100g = it.amountPer100g,
                aliment = aliment,
                nutrient = nutrientRepo.findById(it.idNutrient).orElseThrow()
            )
            aliment.compositions.add(comp)
        }

        createAutoPost(saved.id!!,saved.name)
        return alimentRepo.save(saved).toDTO()
    }

    fun update(id: Int, dto: AlimentDTO): AlimentDTO {
        val existing = alimentRepo.findById(id).orElseThrow()
// ✅ update fields directly
        existing.name = dto.name
        existing.description = dto.description
        existing.type = dto.type
        existing.updatedAt = System.currentTimeMillis()
// ✅ clear old compositions
        existing.compositions.clear()
// ✅ add new ones
        dto.nutrients.forEach {
            val comp = CompositionAlimentEntity(
                id = CompositionAlimentKey(existing.id,it.idNutrient),
                amountPer100g = it.amountPer100g,
                aliment = existing,
                nutrient = nutrientRepo.findById(it.idNutrient).orElseThrow()
            )
            existing.compositions.add(comp)
        }
        val saved = alimentRepo.save(existing)
        return saved.toDTO()
    }

    fun delete(id: Int) {
        alimentRepo.deleteById(id)
    }

    private fun createAutoPost(
        alimentId:Int,
        name:String
    ){
        val userId = (SecurityContextHolder.getContext().authentication?.principal ?: 0) as Int

        val post=
            SocialPostEntity(
                dateTime = LocalDateTime.now(),
                description = name,
                visibility = "PUBLIC",
                userId = userId
            )

        post.contents.add(
            PostContentEntity(
                id =
                    PostContentKey(
                        postId = 0,
                        referenceId = alimentId,
                        type = "ALIMENT"
                    ),
                post = post
            )
        )

        socialRepo.save(post)
    }
}