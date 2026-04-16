package com.example.nutriapp.backend.service


import com.example.nutriapp.backend.dto.RecipeDTO
import com.example.nutriapp.backend.entity.CompositionRecipeEntity
import com.example.nutriapp.backend.entity.CompositionRecipeId
import com.example.nutriapp.backend.entity.IngredientEntity
import com.example.nutriapp.backend.entity.IngredientId
import com.example.nutriapp.backend.entity.RecipeEntity
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.repository.NutrientRepository
import com.example.nutriapp.backend.repository.RecipeRepository
import org.springframework.stereotype.Service

@Service
class RecipeService(
    private val recipeRepo: RecipeRepository,
    private val nutrientRepo: NutrientRepository
) {

    fun getAll(): List<RecipeDTO> =
        recipeRepo.findAll().map { it.toDTO() }

    fun getById(id: Int): RecipeDTO =
        recipeRepo.findById(id).orElseThrow().toDTO()

    fun create(dto: RecipeDTO, userId: Int): RecipeDTO {

        val recipe = RecipeEntity(
            name = dto.name,
            description = dto.description,
            instructions = dto.instructions,
            servings = dto.servings,
            difficultyLevel = dto.difficultyLevel,
            typeM = dto.typeM,

            // 🔥 NOW INCLUDED
            creationDate = dto.creationDate,
            idCookbook = dto.idCookbook,
            idCreator = userId,
            idInitialCreator = dto.idInitialCreator,
            previousRecipeId = dto.previousRecipeId,

            updatedAt = System.currentTimeMillis(),

            compositions = mutableListOf(),
            ingredients = mutableListOf()
        )

        if(recipe.idInitialCreator == null)
        {
            recipe.idInitialCreator = userId
        }

        val saved = recipeRepo.save(recipe)

        // nutrients
        dto.nutrients.forEach {
            val comp = CompositionRecipeEntity(
                id = CompositionRecipeId(it.idNutrient, saved.id),
                amountPer100g = it.amountPer100g,
                recipe = saved,
                nutrient = nutrientRepo.findById(it.idNutrient).orElseThrow()
            )
            saved.compositions.add(comp)
        }

        // ingredients
        dto.ingredients.forEach {
            val ing = IngredientEntity(
                id = IngredientId(it.targetId, saved.id, it.targetType),
                quantity = it.quantity,
                measurementUnit = it.measurementUnit,
                recipe = saved
            )
            saved.ingredients.add(ing)
        }

        return recipeRepo.save(saved).toDTO()
    }

    fun update(id: Int, dto: RecipeDTO): RecipeDTO {

        val existing = recipeRepo.findById(id).orElseThrow()

        existing.name = dto.name
        existing.description = dto.description
        existing.instructions = dto.instructions
        existing.servings = dto.servings
        existing.difficultyLevel = dto.difficultyLevel
        existing.typeM = dto.typeM

        // 🔥 ALSO UPDATE THESE
        existing.creationDate = dto.creationDate
        existing.idCookbook = dto.idCookbook
        existing.idCreator = dto.idCreator
        existing.idInitialCreator = dto.idInitialCreator
        existing.previousRecipeId = dto.previousRecipeId

        existing.updatedAt = System.currentTimeMillis()

        existing.compositions.clear()
        existing.ingredients.clear()

        dto.nutrients.forEach {
            val comp = CompositionRecipeEntity(
                id = CompositionRecipeId(it.idNutrient, existing.id),
                amountPer100g = it.amountPer100g,
                recipe = existing,
                nutrient = nutrientRepo.findById(it.idNutrient).orElseThrow()
            )
            existing.compositions.add(comp)
        }

        dto.ingredients.forEach {
            val ing = IngredientEntity(
                id = IngredientId(it.targetId, existing.id, it.targetType),
                quantity = it.quantity,
                measurementUnit = it.measurementUnit,
                recipe = existing
            )
            existing.ingredients.add(ing)
        }

        return recipeRepo.save(existing).toDTO()
    }

    fun delete(id: Int) {
        recipeRepo.deleteById(id)
    }
}