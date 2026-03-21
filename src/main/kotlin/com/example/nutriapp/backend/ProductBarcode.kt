package com.example.nutriapp.backend
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(name = "product_barcodes")
data class ProductBarcode(
    @Id
    val barcode: String,

    val productId: Int
)