package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.repository.AlimentRepository
import com.example.nutriapp.backend.repository.EventRepository
import com.example.nutriapp.backend.repository.NutrientRepository
import com.example.nutriapp.backend.repository.PostContentRepository
import com.example.nutriapp.backend.repository.ProductRepository
import com.example.nutriapp.backend.repository.RecipeRepository
import org.springframework.stereotype.Service

@Service
class PostContentService(
    private val repo: PostContentRepository,
    private val productRepo: ProductRepository,
    private val alimentRepo: AlimentRepository,
    private val recipeRepo: RecipeRepository,
    private val nutrientRepo: NutrientRepository,
    private val eventRepo: EventRepository
) {

    fun resolveContent(postId: Int): List<Any> {
        val contents = repo.findByPostId(postId)

        return contents.map {
            when (it.type) {
                "PRODUCT" -> productRepo.findById(it.referenceId).orElse(null)
                "ALIMENT" -> alimentRepo.findById(it.referenceId).orElse(null)
                "RECIPE" -> recipeRepo.findById(it.referenceId).orElse(null)
                "NUTRIENT" -> nutrientRepo.findById(it.referenceId).orElse(null)
                "EVENT" -> eventRepo.findById(it.referenceId).orElse(null)
                else -> null
            }
        }.filterNotNull()

    }
}