package emy.backend.lawapp50.app.actor.infrastructure.persistance.entity

import emy.backend.lawapp50.app.actor.domain.model.Student
import jakarta.persistence.Column
import jakarta.persistence.Id
import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*

@Table(name = "students")
class StudentEntity(
    @Id
    @Column("student_id")
    var studentId : Long? = null,
    @Column("promotion_id")
    var promotionId : Long? = null,
    @Column("etablissement_id")
    var etablissementId : Long? = null,
    @Column("matricule")
    var matricule : String? = null,
    @Column("user_id")
    var userId : Long? = null,
    @Column("gender")
    var gender : Char? = null,
)

fun StudentEntity.toDomain() = Student(
    studentId = this.studentId,
    promotionId = this.promotionId,
    etablissementId = this.etablissementId,
    matricule = this.matricule,
    userId = this.userId,
    gender = this.gender
)



