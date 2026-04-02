package emy.backend.lawapp50.app.evaluation.domain.request

import jakarta.validation.constraints.NotNull

class QuestionCaseStudyRequest(
    @NotNull
    val title : String,
    var fileContent : String? =  null,
)

