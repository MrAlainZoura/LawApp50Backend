package emy.backend.lawapp50.app.actor.infrastructure.persistance.entity

import emy.backend.lawapp50.app.actor.domain.model.Teacher

import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*

@Table(name="teachers")
class TeacherEntity (
    @Id
    @Column("teacher_id")
    val teacherId: Long?,
    @Column("matricule")
    val matricule: String?,
    @Column("type_teacher_id")
    val typeTeacherId: Long?,
    @Column("departement")
    val departement: String?,
    @Column("justificatif")
    val justificatif: String,
    @Column("faculte_id")
    val faculteId: Long,
    @Column("user_id")
    var userId : Long? = null,
    @Column("gender")
    var gender : Char? = null,
)

fun TeacherEntity.toDomain() =Teacher(
        teacherId = this.teacherId,
        matricule = this.matricule,
        typeTeacherId = this.typeTeacherId,
        departement = this.departement,
        justificatif = this.justificatif,
        faculteId = this.faculteId,
        gender = this.gender,
        userId = this.userId
    )
