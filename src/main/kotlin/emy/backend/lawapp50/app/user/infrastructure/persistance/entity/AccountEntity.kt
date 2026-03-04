package emy.backend.lawapp50.app.user.infrastructure.persistance.entity

import emy.backend.lawapp50.app.user.domain.model.*
import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*

@Table("accounts")
class AccountEntity(
    @Id
    @Column("id")
    val id: Long? = null,
    @Column("name")
    val name: String,
    @Column("type_account_id")
    val typeAccountId: Long,
    @Column("is_active")
    val isActive: Boolean = true
)
data class AccountDTO(
    val id : Long? = null,
    val name: String,
    val typeAccount : TypeAccount,
)
fun AccountEntity.toAccount(name: String) = TypeAccount(
    typeAccountId = this.typeAccountId,
    name = name,
)
fun AccountEntity.toDomain() = Account(id = this.id, name = this.name, typeAccountId = this.typeAccountId)