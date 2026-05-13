package com.example.nutriapp.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table
import java.io.Serializable

@Embeddable
data class PostContentKey(

    @Column(name = "post_id")
    val postId: Int = 0,

    @Column(name = "reference_id")
    val referenceId: Int = 0,

    @Column(name = "type")
    val type: String = ""

) : Serializable

@Entity
@Table(name = "post_content")
class PostContentEntity(

    @EmbeddedId
    val id: PostContentKey,

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    var post: SocialPostEntity? = null
)

