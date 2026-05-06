package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table
import java.io.Serializable

@Embeddable
data class CompositionProductKey(
    @Column(name = "id_product")
    val productId: Int? = 0,
    @Column(name = "id_nutrient")
    val nutrientId: Int = 0
) : Serializable


@Entity
@Table(name = "composition_products")
class CompositionProductEntity(

    @EmbeddedId
    val id: CompositionProductKey,

    val amountPer100g: Double,

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    val product: ProductEntity,

    @ManyToOne
    @MapsId("nutrientId")
    @JoinColumn(name = "id_nutrient")
    val nutrient: NutrientEntity
)
