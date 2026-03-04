package emy.backend.lawapp50.app.user.infrastructure.persistance.mapper

import emy.backend.lawapp50.app.user.domain.model.*
import emy.backend.lawapp50.app.user.infrastructure.persistance.entity.*

fun UserEntity.toDomain(): UserDto {
    val entity = this
    return UserDto(
        userId = entity.userId,
        email = entity.email,
        phone = entity.phone.toString(),
        username = entity.pseudo.toString(),
        city = entity.city.toString(),
        isPremium = entity.isPremium,
        isCertified = entity.isCertified,
        firstName = entity.firstName,
        lastName = entity.lastName
    )
}

//@OptIn(ExperimentalTime::class)
fun UserDto.toEntityToDto(password: String): UserEntity {
    val user = this
    return UserEntity(
        userId = user.userId,
        pseudo = user.username,
        email = user.email,
        phone = user.phone,
        city = user.city,
        password = password,
        firstName = user.firstName,
        lastName = user.lastName,
//        country = user.country,
        isPremium = user.isPremium,
    )
}


fun User.toEntity(): UserEntity {
    val user = this
    return UserEntity(
        userId = user.userId,
        pseudo = user.username,
        email = user.email,
        phone = user.phone,
        firstName = user.firstName,
        lastName = user.lastName,
        city = user.city,
//        country = user.country,
    )
}

