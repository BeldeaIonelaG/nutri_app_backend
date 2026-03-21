package com.example.nutriapp.backend
import com.example.nutriapp.backend.enums.FoodTargetType
import com.example.nutriapp.backend.enums.PreferenceType
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(
    name = "food_preference",
    indexes = [
        Index(name = "idx_user", columnList = "userId"),
        Index(name = "idx_target", columnList = "targetId")
    ]
)
data class FoodPreference(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val userId: Int,

    @Enumerated(EnumType.STRING)
    val type: PreferenceType,

    @Enumerated(EnumType.STRING)
    val targetType: FoodTargetType,

    val targetId: Int
)