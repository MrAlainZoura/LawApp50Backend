package emy.backend.lawapp50.app.user.infrastructure.persistance.entity

import com.fasterxml.jackson.annotation.*
import org.springframework.data.relational.core.mapping.*
import java.time.*
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

@Table(name = "users")
class UserEntity(
    @Id
    @Column("id")
    val userId: Long? = null,
    @Column("city")
    var city: String? = null,
    @JsonIgnore
    @Column("password")
    var password: String? = "",
    @Column("email")
    var email: String? = null,
    @Column("pseudo")
    var pseudo: String? = null,
    @Column("images")
    var images: String? = null,
    @Column("is_premium")
    var isPremium: Boolean = false,
    @Column("is_certified")
    var isCertified: Boolean = false,
    @Column("is_lock")
    var isLock: Boolean = false,
    @Column("phone")
    var phone: String?=null,
    @Column("first_name")
    var firstName: String,
    @Column("last_name")
    var lastName: String,
    @Column("full_name")
    val fullName: String = "$firstName $lastName",
    @Column("from_service")
    var fromService : String? = null,
    @Column("is_valid")
    var isValid: Boolean = false,
    @Column("created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
)