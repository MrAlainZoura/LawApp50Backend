package emy.backend.lawapp50.app.ouvrages.infrastructure.persistance.repository

import emy.backend.lawapp50.app.ouvrages.infrastructure.persistance.entity.DocumentEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface DocumentRepository : CoroutineCrudRepository<DocumentEntity, Long>
