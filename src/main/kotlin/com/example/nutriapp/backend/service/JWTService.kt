package com.example.nutriapp.backend.service

import com.example.nutriapp.backend.entity.UserEntity

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.filter.OncePerRequestFilter
import java.util.Date

@Service
class JwtService {

    private val secret = "VERY_SECRET_KEY_12345678901234567890"

    fun generateToken(user: UserEntity): String {
        return Jwts.builder()
            .setSubject(user.id.toString())
            .claim("email", user.email)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 86400000))
            .signWith(
                Keys.hmacShaKeyFor(secret.toByteArray()),
                SignatureAlgorithm.HS256
            )
            .compact()
    }

    fun extractUserId(token: String): Int {
        val claims = Jwts.parserBuilder()
            .setSigningKey(secret.toByteArray())
            .build()
            .parseClaimsJws(token)
            .body

        return claims.subject.toInt()
    }

    fun isValid(token: String): Boolean {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(secret.toByteArray())
                .build()
                .parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }
}

@Component
class JwtAuthFilter(
    private val jwtService: JwtService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        val path = request.requestURI

        // ✅ VERY IMPORTANT
        if (path.startsWith("/auth")) {
            filterChain.doFilter(request, response)
            return
        }

        val header = request.getHeader("Authorization")

        if (header != null && header.startsWith("Bearer ")) {
            val token = header.substring(7)

            if (jwtService.isValid(token)) {
                val userId = jwtService.extractUserId(token)

                val auth = UsernamePasswordAuthenticationToken(
                    userId,
                    null,
                    emptyList()
                )

                SecurityContextHolder.getContext().authentication = auth
            }
        }

        filterChain.doFilter(request, response)
    }
}

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtFilter: JwtAuthFilter
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it
                    .requestMatchers("/auth/**").permitAll()   // ✅ allow login/signup
                    .anyRequest().authenticated()              // 🔒 everything else protected
            }

        return http.build()
    }
}