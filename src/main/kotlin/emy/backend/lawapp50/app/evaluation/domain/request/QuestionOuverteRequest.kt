package emy.backend.lawapp50.app.evaluation.domain.request

import emy.backend.lawapp50.app.evaluation.domain.model.QuestionOuverte
import jakarta.validation.constraints.NotNull

class QuestionOuverteRequest(
    @NotNull
    var title : String,
    var fileContent : String? =  null,
)

fun QuestionOuverteRequest.toDomain(questionId : Long) = QuestionOuverte(
    id = null,
    questionId = questionId,
    title = this.title,
    fileContent = this.fileContent,
)

