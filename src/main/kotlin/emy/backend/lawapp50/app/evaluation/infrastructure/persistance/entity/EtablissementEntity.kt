package emy.backend.lawapp50.app.evaluation.infrastructure.persistance.entity

import emy.backend.lawapp50.app.evaluation.domain.model.Etablissement
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.*

@Table(name = "etablissements")
class EtablissementEntity(
    @Id
    @Column("id")
    val id: Long? = null,
    @Column("name")
    val name: String,
    @Column("is_active")
    val isActive: Boolean = true
)

fun EtablissementEntity.toDomain() = Etablissement(
    id = this.id,
    name = this.name
)