package emy.backend.lawapp50.security

import emy.backend.lawapp50.app.user.application.service.*
import emy.backend.lawapp50.app.user.domain.model.UserDto
import emy.backend.lawapp50.app.user.infrastructure.persistance.mapper.toDomain
import emy.backend.lawapp50.app.user.infrastructure.persistance.repository.*
import kotlinx.coroutines.flow.count
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

import java.security.Principal

@Service
class Auth(
    private val repository : UserRepository,
    private val account : AccountService,
    private val mutlipleAccount : AccountUserService
) {
    suspend fun user(): Pair<UserDto?, MutableList<Boolean>>?{
        val allowList = mutableListOf<Boolean>()
        SecurityContextHolder.getContext().authentication?.name?.let {
            val userId = it.toInt(16).toLong()
            val data = repository.findById(userId)
//            if(mutlipleAccount.getAll().count().toInt() != 0){
            mutlipleAccount.findMultipleAccountUser(userId).forEach{
                c->allowList.add(account.isAllow(c.accountId))
            }
            return Pair(data?.toDomain(),allowList)
        }
        return null
    }
    suspend fun userStom(principal: Principal): UserDto? {
        val data = repository.findById(principal.name.toInt().toLong())
        return data?.toDomain()
    }
}