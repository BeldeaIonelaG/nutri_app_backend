package com.example.nutriapp.backend.repository

import com.example.nutriapp.backend.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Int>
