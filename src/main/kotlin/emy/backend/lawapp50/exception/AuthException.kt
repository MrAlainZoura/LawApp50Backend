package emy.backend.lawapp50.exception

import com.fasterxml.jackson.databind.*
import jakarta.servlet.http.*
import org.springframework.security.access.*
import org.springframework.security.core.*
import org.springframework.security.web.*
import org.springframework.security.web.access.*
import org.springframework.stereotype.*
import java.io.*

@Component
class CustomAuthEntryPoint : AuthenticationEntryPoint {
    @Throws(IOException::class)
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        response.contentType = "application/json"
        response.status = HttpServletResponse.SC_UNAUTHORIZED
        val body: MutableMap<String?, Any?> = HashMap<String?, Any?>()
        body["status"] = 401
        body["error"] = "Unauthorized"
        body["message"] = "Accès refusé : token invalide ou manquant."
        body["path"] = request.servletPath
        ObjectMapper().writeValue(response.outputStream, body)
    }
}


@Component
class CustomAccessDeniedHandler : AccessDeniedHandler {
    @Throws(IOException::class)
     override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException:  AccessDeniedException
    ) {
        response.contentType = "application/json"
        response.status = HttpServletResponse.SC_FORBIDDEN
        val body: MutableMap<String?, Any?> = HashMap<String?, Any?>()
        body["status"] = 403
        body["error"] = "Forbidden"
        body["message"] = "Accès interdit : vous n'avez pas les autorisations nécessaires."
        body["path"] = request.servletPath
        ObjectMapper().writeValue(response.outputStream, body)
    }
}
