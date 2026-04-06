package com.example.nutriapp.backend.controller

import com.example.nutriapp.backend.dto.AuthRequest
import com.example.nutriapp.backend.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/signup")
    fun signup(@RequestBody req: AuthRequest) =
        authService.signup(req)

    @PostMapping("/login")
    fun login(@RequestBody req: AuthRequest) =
        authService.login(req)
}