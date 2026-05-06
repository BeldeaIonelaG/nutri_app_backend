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
data class ProductIngredientKey(
    @Column(name = "id_product")
    val productId: Int? = 0,
    @Column(name = "id_aliment")
    val alimentId: Int = 0
) : Serializable


@Entity
@Table(name = "product_ingredients")
class ProductIngredientEntity(

    @EmbeddedId
    val id: ProductIngredientKey,

    val quantity: Double,
    val measurementUnit: String,

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    val product: ProductEntity,

    @ManyToOne
    @MapsId("alimentId")
    @JoinColumn(name = "id_aliment")
    val aliment: AlimentEntity
)