package com.example.nutriapp.backend.repository

import org.springframework.data.jpa.repository.JpaRepository


interface RelationshipRepository : JpaRepository<RelationshipEntity, Int>

