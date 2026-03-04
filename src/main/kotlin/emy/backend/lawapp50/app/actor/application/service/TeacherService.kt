package emy.backend.lawapp50.app.actor.application.service

import emy.backend.lawapp50.app.actor.domain.model.*
import emy.backend.lawapp50.app.actor.infrastructure.persistance.entity.toDomain
import emy.backend.lawapp50.app.actor.infrastructure.persistance.repository.TeacherRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.map
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TeacherService(
    val repository: TeacherRepository
) {
    suspend fun finAll() = coroutineScope {
        repository.findAll().map { it.toDomain() }
    }
    suspend fun create(model : Teacher) = coroutineScope{
        repository.save(model.toEntity()).toDomain()
    }
    suspend fun findByIdTeacher(id : Long): Teacher? = coroutineScope  {
        repository.findById(id)?.toDomain() ?: throw ResponseStatusException(HttpStatusCode.valueOf(404), "ID $id not found.")
    }
    suspend fun findByIdUser(userId : Long): Teacher?  = coroutineScope {
        repository.findByUser(userId)?.toDomain()
    }
    suspend fun update(id : Long,model: Teacher): Teacher {
        val data = repository.findById(id)
        if (data != null && model.userId == data.userId) {
            return repository.save(model.toEntity()).toDomain()
        }
        throw ResponseStatusException(HttpStatusCode.valueOf(403), "Invalid credentials.")
    }
}