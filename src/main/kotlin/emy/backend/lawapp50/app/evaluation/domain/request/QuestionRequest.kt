package emy.backend.lawapp50.app.evaluation.domain.request

import emy.backend.lawapp50.app.evaluation.domain.model.Question
import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity.QuestionEntity
import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity.QuestionOptionEntity
import jakarta.validation.constraints.NotNull

class QuestionRequest(
    @NotNull
    var title : String,
    @NotNull
    var point : Double = 0.0,
)

fun QuestionRequest.toDomain(evaluationId : Long) = Question(
    id = null,
    evaluationId = evaluationId,
    title = this.title,
    point = this.point,
)
