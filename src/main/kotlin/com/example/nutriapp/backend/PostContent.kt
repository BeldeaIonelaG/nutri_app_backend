package com.example.nutriapp.backend
import com.example.nutriapp.backend.enums.ContentType
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "post_content",
    indexes = [Index(name = "idx_post", columnList = "postId")]
)
data class PostContent(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val postId: Int,

    @Enumerated(EnumType.STRING)
    val type: ContentType,

    val referenceId: Int?
)