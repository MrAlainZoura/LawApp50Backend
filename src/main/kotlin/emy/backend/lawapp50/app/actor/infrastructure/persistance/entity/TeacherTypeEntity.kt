package emy.backend.lawapp50.app.actor.infrastructure.persistance.entity

import jakarta.persistence.*

@Table(name = "teacher_types")
class TeacherTypeEntity(
    @Id
    @Column("teacher_type_id")
    var teacherTypeId : Long? = null,
    @Column("name")
    var name : String,
    @Column("is_active")
    var isActive : Boolean = true,
)