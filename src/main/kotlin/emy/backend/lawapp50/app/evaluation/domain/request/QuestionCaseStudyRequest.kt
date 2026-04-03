package emy.backend.lawapp50.app.evaluation.domain.request

import emy.backend.lawapp50.app.evaluation.domain.model.QuestionCaseStudy
import emy.backend.lawapp50.app.evaluation.domain.model.QuestionOuverte
import jakarta.validation.constraints.NotNull

class QuestionCaseStudyRequest(
    @NotNull
    var title : String,
    var fileContent : String? =  null,
)


fun QuestionCaseStudyRequest.toDomain(questionId : Long) = QuestionCaseStudy(
    id = null,
    questionId = questionId,
    title = this.title,
    fileContent = this.fileContent,
)