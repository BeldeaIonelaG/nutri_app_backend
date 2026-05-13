package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.dto.SocialPostDTO
import com.example.nutriapp.backend.entity.PostContentEntity
import com.example.nutriapp.backend.entity.PostContentKey
import com.example.nutriapp.backend.mappers.toDTO
import com.example.nutriapp.backend.mappers.toEntity
import com.example.nutriapp.backend.repository.SocialPostRepository
import org.springframework.stereotype.Service

@Service
class SocialPostService(
    private val postRepo: SocialPostRepository
) {

    fun getFeed(userId: Int): List<SocialPostDTO> =
        postRepo.findAll().map { it.toDTO() }

    fun create(dto: SocialPostDTO, userId: Int): SocialPostDTO {

        val post = dto.toEntity(userId)

        dto.contents.forEach {

            post.contents.add(
                PostContentEntity(
                    id = PostContentKey(
                        0,
                        it.referenceId,
                        it.type
                    ),
                    post = post
                )
            )
        }

        val saved = postRepo.save(post)

        return saved.toDTO()
    }
}