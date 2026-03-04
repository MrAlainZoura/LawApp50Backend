package emy.backend.lawapp50.app.actor.domain.model

import emy.backend.lawapp50.app.actor.infrastructure.persistance.entity.StudentEntity

data class Student(
    val studentId: Long?,
    val promotionId: Long? = null,
    val etablissementId: Long? = null,
    val matricule: String? = null,
    var userId: Long?,
    var gender: Char? = null,
)

fun Student.toEntity() = StudentEntity(
    studentId = this.studentId,
    promotionId = this.promotionId,
    etablissementId = this.etablissementId,
    matricule = this.matricule,
    userId = this.userId,
    gender = this.gender
)