package emy.backend.lawapp50.app.actor.infrastructure.controller

import emy.backend.lawapp50.app.actor.application.service.*
import emy.backend.lawapp50.app.actor.domain.model.*
import emy.backend.lawapp50.route.actor.*
import emy.backend.lawapp50.security.*
import emy.backend.lawapp50.security.monitoring.*
import io.swagger.v3.oas.annotations.*
import jakarta.servlet.http.*
import jakarta.validation.*
import kotlinx.coroutines.*
import org.slf4j.*
import org.springframework.context.annotation.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
@Profile("dev")
class StudentController(
    private val service : StudentService,
    private val auth: Auth,
    private val sentry : SentryService
) {
    private val log = LoggerFactory.getLogger(this::class.java)
    @Operation(summary = "Liste des Etudiants")
    @GetMapping("/{version}/${StudentScope.PROTECTED}",produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun getAllStudent(request: HttpServletRequest) = coroutineScope {
        val startNanos = System.nanoTime()
        try {
            mapOf("accounts" to service.finAllStudent())
        } finally {
            sentry.callToMetric(
                MetricModel(
                    startNanos = startNanos,
                    status = "200",
                    route = "${request.method} /${request.requestURI}",
                    countName = "api.account.getallStudent.count",
                    distributionName = "api.account.getallStudent.latency"
                )
            )
        }
    }

    @Operation(summary = "Création des étudiants")
    @PostMapping("/{version}/${StudentScope.PRIVATE}",produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun createStudent(request: HttpServletRequest, @Valid @RequestBody data: Student) = coroutineScope {
        val startNanos = System.nanoTime()
        val userConnect = auth.user()
        try {
            data.studentId = userConnect?.first?.userId
            val student = service.create(data)

        } finally {
            sentry.callToMetric(
                MetricModel(
                    startNanos = startNanos,
                    status = "200",
                    route = "${request.method} /${request.requestURI}",
                    countName = "api.account.createStudent.count",
                    distributionName = "api.account.createStudent.latency"
                )
            )
        }
    }
}