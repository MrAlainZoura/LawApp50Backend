package emy.backend.lawapp50.app.evaluation.domain.request

import emy.backend.lawapp50.app.evaluation.domain.model.QuestionOption
import jakarta.validation.constraints.NotNull

class QuestionOptionRequest(
    @NotNull
    var option : String,
    @NotNull
    var isGoal : Boolean,
)

fun QuestionOptionRequest.toDomain(questionId : Long) = QuestionOption(
    id = null,
    questionId = questionId,
    option = this.option,
    isValid = this.isGoal
)

