package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.PostContentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostContentRepository :
    JpaRepository<PostContentEntity, Int> {

    fun findByPostId(postId: Int): List<PostContentEntity>
}