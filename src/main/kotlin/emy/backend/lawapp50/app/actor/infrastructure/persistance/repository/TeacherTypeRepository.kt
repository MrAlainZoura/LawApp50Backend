package emy.backend.lawapp50.app.actor.infrastructure.persistance.repository

import emy.backend.lawapp50.app.actor.infrastructure.persistance.entity.TeacherTypeEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TeacherTypeRepository : CoroutineCrudRepository<TeacherTypeEntity, Long> {}