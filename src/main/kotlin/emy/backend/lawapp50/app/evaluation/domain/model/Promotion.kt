package emy.backend.lawapp50.app.evaluation.domain.model

import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity.PromotionEntity

data class Promotion (
    val id: Long? = null,
    val name: String,
    val isActive: Boolean = true
)

fun Promotion.toEntity() = PromotionEntity(
    id = this.id,
    name = this.name
)