package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.repository.NutrientIntakeRepository
import com.example.nutriapp.backend.repository.NutrientRepository
import org.springframework.stereotype.Service

@Service
class NutrientIntakeService(
    private val repo: NutrientIntakeRepository,
    private val nutrientRepo: NutrientRepository
) {

    fun getDailyTotals(userId: Int): Map<String, Double> {
        val intakes = repo.findByUserId(userId)

        return intakes.groupBy { it.nutrientId }
            .mapValues { (_, list) ->
                list.sumOf { it.quantity }
            }
            .mapKeys { (nutrientId, _) ->
                nutrientRepo.findById(nutrientId).orElseThrow().name
            }
    }
}


