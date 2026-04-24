package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.SocialPostDTO
import com.example.nutriapp.backend.service.SocialPostService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class SocialPostController(
    private val service: SocialPostService
) {

    @GetMapping
    fun getFeed(): List<SocialPostDTO> {
        val userId = (SecurityContextHolder
            .getContext().authentication?.principal ?: 0) as Int

        return service.getFeed(userId)
    }

    @PostMapping
    fun create(@RequestBody dto: SocialPostDTO): SocialPostDTO {

        val userId = (SecurityContextHolder
            .getContext().authentication?.principal ?: 0) as Int

        return service.create(dto, userId)
    }
}