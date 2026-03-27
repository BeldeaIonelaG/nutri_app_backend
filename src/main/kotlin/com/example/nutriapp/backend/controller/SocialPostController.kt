package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.repository.SocialPostRepository
import com.example.nutriapp.backend.service.PostContentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.nutriapp.backend.service.SocialPostService
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/posts")
class SocialPostController(
    private val service: SocialPostService,
    private val postContentService: PostContentService
) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}/content")
    fun getContent(@PathVariable id: Int) =
        postContentService.resolveContent(id)

}