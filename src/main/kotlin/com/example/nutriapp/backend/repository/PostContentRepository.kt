package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.PostContentEntity
import com.example.nutriapp.backend.entity.PostContentKey
import org.springframework.data.jpa.repository.JpaRepository

interface PostContentRepository : JpaRepository<PostContentEntity, PostContentKey>