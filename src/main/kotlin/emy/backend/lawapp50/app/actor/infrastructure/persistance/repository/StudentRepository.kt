package emy.backend.lawapp50.app.actor.infrastructure.persistance.repository

import emy.backend.lawapp50.app.actor.infrastructure.persistance.entity.StudentEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CoroutineCrudRepository<StudentEntity, Long> {
    @Query("SELECT * FROM students WHERE user_id = :userId")
    suspend fun findByUser(userId: Long) : StudentEntity?
}