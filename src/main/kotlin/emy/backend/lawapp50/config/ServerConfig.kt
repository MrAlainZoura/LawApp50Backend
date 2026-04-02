package emy.backend.lawapp50.config

import com.fasterxml.jackson.databind.ObjectMapper
import emy.backend.lawapp50.app.user.domain.model.FromServiceState
import emy.backend.lawapp50.app.user.infrastructure.persistance.entity.UserEntity
import emy.backend.lawapp50.app.user.infrastructure.persistance.mapper.toDomain
import emy.backend.lawapp50.app.user.infrastructure.persistance.repository.UserRepository
import emy.backend.lawapp50.exception.CustomAccessDeniedHandler
import emy.backend.lawapp50.exception.CustomAuthEntryPoint
import emy.backend.lawapp50.security.JwtAuthFilter
import emy.backend.lawapp50.utils.Mode
import jakarta.annotation.PostConstruct
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.*
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Profile(Mode.DEV)
@EnableWebSecurity
@Configuration
class ServerConfig(
    private val customAuthEntryPoint: CustomAuthEntryPoint,
    private val customAccessDeniedHandler: CustomAccessDeniedHandler,
    private val jwtAuthFilter: JwtAuthFilter,
    private val repository: UserRepository
) : WebMvcConfigurer {
    private val log = LoggerFactory.getLogger(this::class.java)
    @PostConstruct
    fun init() {
        log.info("✅ ServerConfig is active")
    }
    @Bean
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
      return httpSecurity
            .csrf { csrf -> csrf.disable() }
          .cors { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .exceptionHandling { configurer ->
                configurer
                    .authenticationEntryPoint(customAuthEntryPoint)
                    .accessDeniedHandler(customAccessDeniedHandler)
            }
          .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter::class.java)
          .httpBasic { it.disable() }
          .formLogin { it.disable() }
          .oauth2Login { oauth -> oauth.successHandler(oAuth2SuccessHandler()) }
          .build()
    }

    @Bean
    fun oAuth2SuccessHandler(): AuthenticationSuccessHandler {
        return AuthenticationSuccessHandler { request, response, authentication ->
            val token = authentication as OAuth2AuthenticationToken
            response.contentType = "application/json"
            response.characterEncoding = "UTF-8"
            val mapper = ObjectMapper()
            val user = token.principal as OAuth2User
            val email = user.attributes["email"] as String?
            val name = user.attributes["name"] as String?
            val picture = user.attributes["picture"] as String?
            val data = mapOf(
                "email" to user.attributes["email"],
                "name" to user.attributes["name"],
                "picture" to user.attributes["picture"]
            )
            println("Email: $email")
            println("Name: $name")
            println("picture: $picture")
            if (email != null) {
                runBlocking{
                    val userSystem = repository.findByPhoneOrEmail(email)
                    if (userSystem != null) {
                       userSystem.isValid = true
                       userSystem.fromService = FromServiceState.GOOGLE_ACCOUNT.name
                       val data = repository.save(userSystem).toDomain()
//                        response.writer.write(mapper.writeValueAsString(data))
                    } else{
                        val entity = UserEntity(
                            password = "",
                            email = email,
                            pseudo = name,
                            phone = "",
                            images = picture,
                            city = "",
                            lastName = "",
                            firstName = "",
                            isValid = true,
                            fromService = FromServiceState.GOOGLE_ACCOUNT.name
                        )
                        val data = repository.save(entity).toDomain()
//                        response.writer.write(mapper.writeValueAsString(data))
                    }
                }
            }
            response.sendRedirect("http://localhost:5000/dashboard")

            // 👉 ici :
            // - créer utilisateur en DB
            // - générer JWT
            // - etc.

            // redirection vers frontend
//            response.sendRedirect("http://localhost:5173/dashboard")
        }
    }
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/property/**")
            .addResourceLocations(
                "file:opt/backend/casa/property/",
//                "file:casa/property/bedroom/",
//                "file:casa/property/room/",
//                "file:casa/property/kitchen/",
//                "file:casa/profil/",
//                "file:casa/realisation/",
            )
    }
}
