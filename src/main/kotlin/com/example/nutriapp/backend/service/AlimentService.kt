package com.example.nutriapp.backend.service

import org.springframework.stereotype.Service
import com.example.nutriapp.backend.repository.AlimentRepository
import com.example.nutriapp.backend.repository.CompositionAlimentRepository
import com.example.nutriapp.backend.repository.NutrientRepository

@Service
class AlimentService(
    private val alimentRepo: AlimentRepository,
    private val compRepo: CompositionAlimentRepository,
    private val nutrientRepo: NutrientRepository
) {

    fun getAll() = alimentRepo.findAll()


    fun getAlimentWithNutrients(id: Int): Map<String, Any> {
        val aliment = alimentRepo.findById(id).orElseThrow()
        val comps = compRepo.findByIdAliment(id)

        val nutrients = comps.map {
            val nutrient = nutrientRepo.findById(1).orElseThrow()
            mapOf(
                "nutrient" to nutrient.name,
                "amount" to it.amountPer100g,
                "unit" to nutrient.measurementUnit
            )
        }

        return mapOf(
            "id" to aliment.id,
            "name" to aliment.name,
            "nutrients" to nutrients
        )
    }
}
