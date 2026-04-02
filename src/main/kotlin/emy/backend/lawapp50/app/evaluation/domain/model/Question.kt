package emy.backend.lawapp50.app.evaluation.domain.model

import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity.QuestionEntity

class Question(
    val id: Long? = null,
    val travailPratiqueId : Long,
    val title : String,
    val point : Double = 0.0,
)

fun Question.toEntity() = QuestionEntity(
    id = this.id,
    travailPratiqueId = this.travailPratiqueId,
    title = this.title,
    point = this.point,
)