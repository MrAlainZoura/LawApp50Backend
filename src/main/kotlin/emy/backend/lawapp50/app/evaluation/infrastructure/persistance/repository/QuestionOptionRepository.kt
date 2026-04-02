package emy.backend.lawapp50.app.evaluation.infrastructure.persistance.repository

import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity.QuestionOptionEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface QuestionOptionRepository  : CoroutineCrudRepository<QuestionOptionEntity, Long>{

}
