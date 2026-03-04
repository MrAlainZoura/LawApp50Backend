package emy.backend.lawapp50.app.actor.domain.model

import emy.backend.lawapp50.app.actor.infrastructure.persistance.entity.Actor
import emy.backend.lawapp50.app.actor.infrastructure.persistance.entity.TeacherEntity
import jakarta.persistence.Column

data class Teacher(
    val teacherId : Long?,
    val matricule : String? = null,
    val typeTeacherId : Long?,
    val departement : String?,
    val justificatif : String,
    val faculteId: Long,
    var userId : Long?,
    var gender : Char? = null,
)

fun Teacher.toEntity() = TeacherEntity(
    teacherId = this.teacherId,
    matricule = this.matricule,
    typeTeacherId = this.typeTeacherId,
    departement = this.departement,
    justificatif = this.justificatif,
    faculteId = this.faculteId,
    gender = this.gender,
    userId = this.userId
  )


