package emy.backend.lawapp50.app.evaluation.infrastructure.persistance.repository

import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity.QuestionOuverteEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface QuestionOuverteRepository  : CoroutineCrudRepository<QuestionOuverteEntity, Long>{

}
