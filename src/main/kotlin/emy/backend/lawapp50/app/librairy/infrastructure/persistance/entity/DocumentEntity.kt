package emy.backend.lawapp50.app.ouvrages.infrastructure.persistance.entity

import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*
import java.time.LocalDateTime

@Table(  "ouvrages")
class DocumentEntity(
    @Id
    @Column("id")
    val id      : Long? = null,
    @Column("user_id")
    val userId  : Long,
    @Column("titre")
    val titre   : String,
    @Column("description")
    val description   : String,
    @Column("titre")
    val typeDocument : String,
    @Column("background_image")
    val backGroundImage : String? = null,
    @Column("file_book")
    val fileBook  : String?,
    @Column("is_active")
    val isActive: Boolean = true,
    @Column("price")
    val price: Long? = null,
    @Column("devise")
    val deviseId: Long? = null,
    @Column("is_premium")
    val isPremium: Boolean = false,
    @Column("date_publication")
    val datePublication: LocalDateTime = LocalDateTime.now(),
)