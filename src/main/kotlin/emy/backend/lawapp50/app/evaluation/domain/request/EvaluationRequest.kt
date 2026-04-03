package emy.backend.lawapp50.app.evaluation.domain.request

import emy.backend.lawapp50.app.evaluation.domain.model.Evaluation
import emy.backend.lawapp50.app.evaluation.domain.model.QuestionOption
import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class EvaluationRequest(
    @NotNull
    val title : String,
    val description : String,
    val compteur : Long? = null,
    var fileContent : String? =  null,
    @NotNull
    val startDate: LocalDate,
    @NotNull
    val endDate: LocalDate,
    val option : List<QuestionOptionRequestDAO>? = emptyList(),
    val ouverte : List<QuestionOuverteRequestDAO>? = emptyList(),
    val caseStudy : List<QuestionCaseStudyRequestDAO>? = emptyList(),
)

data class QuestionOptionRequestDAO(
    val question :QuestionRequest,
    val questionOption : List<QuestionOptionRequest>?
)
data class QuestionOuverteRequestDAO(
    val question :QuestionRequest,
    val questionOuverte : List<QuestionOuverteRequest>?
)

data class QuestionCaseStudyRequestDAO(
    val question :QuestionRequest,
    val questionCaseStudy : List<QuestionCaseStudyRequest>?
)

fun EvaluationRequest.toDomain(userId : Long) = Evaluation(
    title = this.title,
    description = this.description,
    fileContent = this.fileContent,
    userId = userId,
    startDate = this.startDate,
    endDate = this.endDate,
)