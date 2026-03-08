package emy.backend.lawapp50.app.actor.infrastructure.persistance.repository

import emy.backend.lawapp50.app.actor.infrastructure.persistance.entity.TeacherEtablissementEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TeacherEtablissementRepository  : CoroutineCrudRepository<TeacherEtablissementEntity, Long>{
//    @Query("SELECT * FROM teachers WHERE user_id = :userId")
//    suspend fun findByUser(userId: Long) : TeacherEntity?
}
