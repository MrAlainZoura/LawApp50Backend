package emy.backend.lawapp50.app.actor.infrastructure.persistance.entity

import jakarta.persistence.Column

abstract class Actor(
    @Column("user_id")
    var userId : Long? = null,
    @Column("first_name")
    var firstName : String = "",
    @Column("last_name")
    var lastName : String = "",
    @Column("full_name")
    var fullName : String = "",
    @Column("gender")
    var gender : Char? = null,
)