package emy.backend.lawapp50.app.evaluation.domain.model

import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity.QuestionCaseStudyEntity

class QuestionCaseStudy(
    val id: Long? = null,
    val questionId : Long,
    val title : String,
    var fileContent : String? =  null,
)

fun QuestionCaseStudy.toEntity() = QuestionCaseStudyEntity(
    id = this.id,
    questionId = this.questionId,
    title = this.title,
    fileContent = this.fileContent,
)