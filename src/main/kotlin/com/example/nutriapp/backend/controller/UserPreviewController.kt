package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val service: UserService
){

    @GetMapping("/{id}")
    fun getPreview(
        @PathVariable id:Int
    )=
        service.getPreview(id)
}