package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.SocialPostDTO
import com.example.nutriapp.backend.entity.PostContentEntity
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.PostContentRepository
import com.example.nutriapp.backend.repository.SocialPostRepository
import org.springframework.stereotype.Service

@Service
class SocialPostService(
    private val postRepo: SocialPostRepository,
    private val contentRepo: PostContentRepository
) {

    fun getFeed(userId: Int): List<SocialPostDTO> =
        postRepo.findAll().map { it.toDTO() }

    fun create(dto: SocialPostDTO, userId: Int): SocialPostDTO {

        val post = dto.toEntity(userId)

        val saved = postRepo.save(post)

        dto.contents.forEach {
            val content = PostContentEntity(
                postId = saved.id,
                referenceId = it.referenceId,
                type = it.type
            )
            contentRepo.save(content)
        }

        return postRepo.findById(saved.id).get().toDTO()
    }
}