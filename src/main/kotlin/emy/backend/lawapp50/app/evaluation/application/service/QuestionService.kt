package emy.backend.lawapp50.app.evaluation.application.service

import emy.backend.lawapp50.app.evaluation.domain.model.*
import emy.backend.lawapp50.app.evaluation.domain.model.toEntity
import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity.*
import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.repository.QuestionRepository
import kotlinx.coroutines.coroutineScope
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class QuestionService(private val repository: QuestionRepository) {
    suspend fun create(model : Question) = coroutineScope {
        repository.save(model.toEntity())
    }
    suspend fun findById(id : Long) = coroutineScope {
        val data = repository.findById(id)?: throw ResponseStatusException(HttpStatusCode.valueOf(404), "ID Is Not Found.")
        data.toDomain()
    }
}