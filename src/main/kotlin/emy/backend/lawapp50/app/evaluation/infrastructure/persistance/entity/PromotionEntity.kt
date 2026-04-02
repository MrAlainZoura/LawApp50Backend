package emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity

import emy.backend.lawapp50.app.evaluation.domain.model.Promotion
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.*

@Table(name = "promotions")
class PromotionEntity (
    @Id
    @Column("id")
    val id: Long? = null,
    @Column("name")
    val name: String,
    @Column("is_active")
    val isActive: Boolean = true
)

fun PromotionEntity.toDomain() = Promotion(
    id = this.id,
    name = this.name
)