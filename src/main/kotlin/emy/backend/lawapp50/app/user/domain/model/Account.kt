package emy.backend.lawapp50.app.user.domain.model

import emy.backend.lawapp50.app.user.infrastructure.persistance.entity.AccountEntity

data class Account(
    val id : Long? = null,
    val name: String,
    val typeAccountId : Long
)

fun Account.toEntity() = AccountEntity(
    id = this.id,
    name = this.name,
    typeAccountId = this.typeAccountId,
)