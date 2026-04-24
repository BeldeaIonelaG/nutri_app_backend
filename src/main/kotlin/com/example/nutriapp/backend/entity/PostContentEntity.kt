package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "post_content")
class PostContentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "post_id")
    var postId: Int,

    @Column(name = "reference_id")
    var referenceId: Int,

    var type: String,

    @ManyToOne
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    var post: SocialPostEntity? = null
)

