package com.example.nutriapp.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "product_barcodes")
class ProductBarcodeEntity(

    @Id
    var barcode: String,

    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: ProductEntity
)