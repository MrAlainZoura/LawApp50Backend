package emy.backend.lawapp50.app.user.infrastructure.persistance.entity

import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

@Table(name = "type_accounts")
class TypeAccountEntity(
    @Id
    @Column("id")
    val id: Long? = null,
    @Column("name")
    val name: String,
    @Column("is_active")
    val isActive: Boolean = true
)