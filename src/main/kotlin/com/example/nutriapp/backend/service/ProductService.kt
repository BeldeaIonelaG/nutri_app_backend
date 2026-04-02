package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.ProductDTO
import com.example.nutriapp.backend.entity.CompositionProductEntity
import com.example.nutriapp.backend.entity.ProductBarcodeEntity
import com.example.nutriapp.backend.entity.ProductEntity
import com.example.nutriapp.backend.entity.ProductIngredientEntity
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.repository.AlimentRepository
import com.example.nutriapp.backend.repository.NutrientRepository
import com.example.nutriapp.backend.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val repo: ProductRepository,
    private val nutrientRepo: NutrientRepository,
    private val alimentRepo: AlimentRepository
) {

    fun getAll() = repo.findAll().map { it.toDTO() }

    fun getById(id: Int) =
        repo.findById(id).orElseThrow().toDTO()

    fun create(dto: ProductDTO): ProductDTO {

        val product = ProductEntity(
            name = dto.name,
            description = dto.description,
            type = dto.type
        )

        // compositions
        dto.nutrients.forEach {
            product.compositions.add(
                CompositionProductEntity(
                    amountPer100g = it.amountPer100g,
                    product = product,
                    nutrient = nutrientRepo.findById(it.idNutrient).orElseThrow()
                )
            )
        }

        // ingredients
        dto.ingredients.forEach {
            product.ingredients.add(
                ProductIngredientEntity(
                    quantity = it.quantity,
                    measurementUnit = it.measurementUnit,
                    product = product,
                    aliment = alimentRepo.findById(it.idAliment).orElseThrow()
                )
            )
        }

        // barcodes
        dto.barcodes.forEach {
            product.barcodes.add(ProductBarcodeEntity(it, product))
        }

        return repo.save(product).toDTO()
    }

    fun update(id: Int, dto: ProductDTO): ProductDTO {
        val product = repo.findById(id).orElseThrow()

        product.name = dto.name
        product.description = dto.description
        product.type = dto.type

        product.compositions.clear()
        product.ingredients.clear()
        product.barcodes.clear()

        dto.nutrients.forEach {
            product.compositions.add(
                CompositionProductEntity(
                    amountPer100g = it.amountPer100g,
                    product = product,
                    nutrient = nutrientRepo.findById(it.idNutrient).orElseThrow()
                )
            )
        }

        dto.ingredients.forEach {
            product.ingredients.add(
                ProductIngredientEntity(
                    quantity = it.quantity,
                    measurementUnit = it.measurementUnit,
                    product = product,
                    aliment = alimentRepo.findById(it.idAliment).orElseThrow()
                )
            )
        }

        dto.barcodes.forEach {
            product.barcodes.add(ProductBarcodeEntity(it, product))
        }

        return repo.save(product).toDTO()
    }

    fun delete(id: Int) = repo.deleteById(id)
}