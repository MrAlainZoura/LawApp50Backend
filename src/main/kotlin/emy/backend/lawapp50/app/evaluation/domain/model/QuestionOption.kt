package emy.backend.lawapp50.app.evaluation.domain.model

import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity.QuestionOptionEntity

class QuestionOption(
    val id: Long? = null,
    val questionId : Long,
    val option : String,
    val isValid: Boolean = false,
)

fun QuestionOption.toEntity() = QuestionOptionEntity(
    id = this.id,
    questionId = this.questionId,
    option = this.option,
    isValid = this.isValid,
)