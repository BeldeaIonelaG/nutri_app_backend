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

        println("✅ JWT PARSED - subject: ${claims.subject}, email: ${claims["email"]}")

        return claims.subject.toInt()
    }

    fun isValid(token: String): Boolean {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(secret.toByteArray())
                .build()
                .parseClaimsJws(token)

            println("✅ TOKEN VALID")
            true
        } catch (e: Exception) {
            println("❌ TOKEN INVALID: ${e.message}")
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
        val header = request.getHeader("Authorization")

        println("\n================ JWT FILTER ================")
        println("📍 PATH: $path")
        println("📍 AUTH HEADER: $header")

        // ✅ Skip auth endpoints
        if (path.startsWith("/auth")) {
            println("➡️ Skipping auth endpoint")
            filterChain.doFilter(request, response)
            return
        }

        if (header == null) {
            println("❌ NO AUTH HEADER → request will be UNAUTHORIZED")
            filterChain.doFilter(request, response)
            return
        }

        if (!header.startsWith("Bearer ")) {
            println("❌ INVALID HEADER FORMAT")
            filterChain.doFilter(request, response)
            return
        }

        val token = header.substring(7)
        println("✅ TOKEN EXTRACTED: $token")

        if (!jwtService.isValid(token)) {
            println("❌ TOKEN FAILED VALIDATION")
            filterChain.doFilter(request, response)
            return
        }

        val userId = jwtService.extractUserId(token)
        println("✅ USER ID FROM TOKEN: $userId")

        val currentAuth = SecurityContextHolder.getContext().authentication
        println("📍 EXISTING AUTH: $currentAuth")

        if (currentAuth == null) {

            val auth = UsernamePasswordAuthenticationToken(
                userId,
                null,
                emptyList() // ⚠️ IMPORTANT: no roles
            )

            println("🔥 SETTING AUTHENTICATION FOR USER: $userId")

            SecurityContextHolder.getContext().authentication = auth

        } else {
            println("⚠️ AUTH ALREADY EXISTS, SKIPPING")
        }

        println("📍 FINAL AUTH: ${SecurityContextHolder.getContext().authentication}")
        println("===========================================\n")

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

        println("🚨 SECURITY CONFIG INITIALIZED")

        return http
            .csrf { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests {
                it
                    .requestMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }
}