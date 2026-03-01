package emy.backend.lawapp50.app.user.domain.model

import emy.backend.lawapp50.app.user.infrastructure.persistance.entity.AccountUserEntity

data class AccountUser(
    val id: Long? = null,
    val userId: Long,
    val accountId:Long
)
fun AccountUser.toEntity() = AccountUserEntity(
    id = this.id,
    accountId = this.accountId,
    userId = this.userId,
)