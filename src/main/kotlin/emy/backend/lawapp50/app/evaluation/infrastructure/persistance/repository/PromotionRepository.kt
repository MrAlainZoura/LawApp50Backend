package emy.backend.lawapp50.app.evaluation.infrastructure.persistance.repository

import emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity.PromotionEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface PromotionRepository  : CoroutineCrudRepository<PromotionEntity, Long>{

}
