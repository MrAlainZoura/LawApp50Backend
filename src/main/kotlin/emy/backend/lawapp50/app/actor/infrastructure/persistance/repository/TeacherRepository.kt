package emy.backend.lawapp50.app.actor.infrastructure.persistance.repository

import emy.backend.lawapp50.app.actor.infrastructure.persistance.entity.TeacherEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TeacherRepository  : CoroutineCrudRepository<TeacherEntity, Long>{
    @Query("SELECT * FROM teachers WHERE user_id = :userId")
    suspend fun findByUser(userId: Long) : TeacherEntity?
}
